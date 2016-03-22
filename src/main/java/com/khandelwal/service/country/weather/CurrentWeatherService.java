package com.khandelwal.service.country.weather;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khandelwal.domainmodel.OpenWeather;
import com.khandelwal.domainmodel.OpenWeather.List;
import com.khandelwal.domainmodel.weather.Humidity;
import com.khandelwal.domainmodel.weather.Temperature;
import com.khandelwal.domainmodel.weather.Weather;
import com.khandelwal.domainmodel.weather.Wind;
import com.khandelwal.service.UtilityService;

@SuppressWarnings("rawtypes")
@Service(value = "currentWeatherService")
@ManagedResource
public class CurrentWeatherService implements UtilityService {

	private Map<String,Collection<Weather>> weatherMap = new HashMap<String,Collection<Weather>> ();
	private @Value("${country.service.weather.url}") String weatherServiceUrl;
	private static final Logger logger = LoggerFactory
			.getLogger(CurrentWeatherService.class);

	public Collection<Weather> getUtility(final String cityName) {
		logger.info("weatherServiceUrl:", weatherServiceUrl);

		if (weatherMap.containsKey(cityName)) {
			logger.info ("Inside getUtility method of CurrentWeatherService. Returning value from cached");
			return weatherMap.get(cityName);
		}
		
		Collection<Weather> weather = new ArrayList<Weather>();
		ResponseEntity<OpenWeather> OpenWeatherResponseEntity = new RestTemplate()
				.exchange((weatherServiceUrl + cityName), HttpMethod.GET, null,
						OpenWeather.class);

		OpenWeather openWeather = OpenWeatherResponseEntity.getBody();

		for (List list : openWeather.list) {

			weather.add(new Weather(new Temperature(list.temp.min,
					list.temp.max, "Celcius"), new Wind(list.speed, list.deg),
					new Humidity(list.humidity, "%")));
		}

		weatherMap.put(cityName, weather);
		logger.info ("Inside getUtility method of CurrentWeatherService. Size of weatherMap:", weatherMap.size());
		
		return weather;
	}
	
	@ManagedOperation
	@Scheduled (fixedDelay = 600000)
	public void refreshWeatherCollection () {
		logger.info ("Inside refreshWeatherCollection method of CurrentWeatherService");
		weatherMap.clear();
	}
}
