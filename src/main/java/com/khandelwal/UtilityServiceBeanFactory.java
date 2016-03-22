package com.khandelwal;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.khandelwal.service.UtilityService;
import com.khandelwal.service.UtilityServiceFactory;

@Configuration
public class UtilityServiceBeanFactory implements BeanFactoryAware {

	private final String WEATHER = "weather";
	private final String ISO_CODE = "isocode";
	private final String POSTAL_CODE = "postalcode";
	private final String CALLING_CODE = "callingcode";
	
	private final String CURRENT_WEATHER_SERVICE = "currentWeatherService";
	private final String ISO_CODE_SERVICE = "isoCodeService";
	private final String POSTAL_CODE_SERVICE = "postalCodeService";
	private final String CALLING_CODE_SERVICE = "callingCodeService";

	@Autowired
	private BeanFactory beanFactory;

	@Bean(name = "weatherCacheManager")
	public CacheManager getCacheManager() {
		return new GuavaCacheManager("currentWeather");
	}

	@SuppressWarnings("rawtypes")
	@Bean(name = "utilityServiceFactory")
	public UtilityServiceFactory utilityServiceLocatorFactoryBean() {

		ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
		serviceLocatorFactoryBean
				.setServiceLocatorInterface(UtilityServiceFactory.class);
		Properties serviceMappings = new Properties();
		serviceMappings.put(WEATHER, CURRENT_WEATHER_SERVICE);
		serviceMappings.put(ISO_CODE, ISO_CODE_SERVICE);
		serviceMappings.put(POSTAL_CODE, POSTAL_CODE_SERVICE);
		serviceMappings.put(CALLING_CODE, CALLING_CODE_SERVICE);
		serviceLocatorFactoryBean.setServiceMappings(serviceMappings);
		serviceLocatorFactoryBean.afterPropertiesSet();
		serviceLocatorFactoryBean.setBeanFactory(beanFactory);
		return (UtilityServiceFactory) serviceLocatorFactoryBean.getObject();
	}

	@Override
	public void setBeanFactory(final BeanFactory beanFactory)
			throws BeansException {

		this.beanFactory = beanFactory;
	}

}
