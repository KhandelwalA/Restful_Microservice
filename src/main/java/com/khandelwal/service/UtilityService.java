package com.khandelwal.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonParseException;
import com.khandelwal.domainmodel.weather.Weather;

public interface UtilityService <T> {

	public Collection<T> getUtility (final String searchText) throws JsonParseException, RestClientException, IOException;
}
