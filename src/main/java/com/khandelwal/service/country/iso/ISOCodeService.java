package com.khandelwal.service.country.iso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khandelwal.domainmodel.iso.ISOCode;
import com.khandelwal.service.UtilityService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SuppressWarnings("rawtypes")
@Service(value = "isoCodeService")
@ManagedResource
public class ISOCodeService implements UtilityService {

	private @Value("${country.service.isoCode.url}") String isoCodeServiceUrl;
	private Map<String, Collection<ISOCode>> isoCodeMap = new HashMap<String, Collection<ISOCode>>();
	private final Logger logger = LoggerFactory.getLogger(ISOCodeService.class);

	@Override
	@HystrixCommand(fallbackMethod = "backUpMethod")
	public Collection<ISOCode> getUtility(String countryName) {

		if (isoCodeMap.containsKey(countryName)) {
			return isoCodeMap.get(countryName);
		}

		String strMessage = "For more services please visit Khandelwal.com services";
		List<Object> listMessage = new ArrayList<Object>();
		listMessage.add(strMessage);

		Collection<ISOCode> isoCodeCollection = new ArrayList<ISOCode>();

		ResponseEntity<ISOCode> isoCodeResponseEntity = new RestTemplate()
				.exchange((isoCodeServiceUrl + countryName), HttpMethod.GET,
						null, ISOCode.class);

		ISOCode isoCode = isoCodeResponseEntity.getBody();
		isoCode.getRestResponse().setMessages(listMessage);
		isoCodeCollection.add(isoCodeResponseEntity.getBody());

		logger.info("ISOCodeService:isoCodeCollection: ", isoCodeCollection);

		isoCodeMap.put(countryName, isoCodeCollection);

		return isoCodeCollection;
	}

	/**
	 * This is resilient (failback) method
	 * 
	 * @param locationName
	 * @return
	 */
	public Collection backUpMethod(String countryName) {

		logger.info("ISOCodeService:backUpMethod: Resilience in action");
		return new ArrayList();
	}

	/* Jmx support */
	@ManagedOperation
	public void resetIsoCodeMap() {
		isoCodeMap.clear();
	}

}
