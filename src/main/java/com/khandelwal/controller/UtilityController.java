package com.khandelwal.controller;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.fasterxml.jackson.core.JsonParseException;
import com.khandelwal.domainmodel.Location;
import com.khandelwal.domainmodel.weather.Weather;
import com.khandelwal.exception.ServiceNotAvailableException;
import com.khandelwal.service.UtilityService;
import com.khandelwal.service.UtilityServiceFactory;

@RestController
@RequestMapping(value = "/utility")
public class UtilityController {

	@SuppressWarnings("rawtypes")
	private UtilityServiceFactory utilityServiceFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	public UtilityController(final UtilityServiceFactory utilityServiceFactory) {

		this.utilityServiceFactory = utilityServiceFactory;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{serviceName}/{searchText}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getUtility (
			final @PathVariable("serviceName") String serviceName,
			final @PathVariable("searchText") String searchText)
			throws ServiceNotAvailableException, JsonParseException,
			RestClientException, IOException, NoSuchBeanDefinitionException {

		UtilityService utilityService = (UtilityService) utilityServiceFactory
				.instanceUtilityService (serviceName.toLowerCase());
		Collection collectionResponse;

		collectionResponse = utilityService.getUtility(searchText);
		System.out.println("collectionResponse:"+ collectionResponse.size());
		Location location = new Location (searchText, collectionResponse);
		
		location.add(linkTo(
				methodOn(UtilityController.class).getUtility(serviceName, searchText ))
				.withSelfRel());
		
		return new ResponseEntity<Location>(location, HttpStatus.OK);
		//return new ResponseEntity<Weather>(weather, HttpStatus.OK);

	}
}
