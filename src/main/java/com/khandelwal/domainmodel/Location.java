package com.khandelwal.domainmodel;

import java.util.Collection;

import org.springframework.hateoas.ResourceSupport;

import com.khandelwal.domainmodel.weather.Weather;

public class Location <T> extends ResourceSupport {

	public String name;
	public Collection <T> collection;
	
	public Location(String name, Collection<T> collection) {
		super();
		this.name = name;
		this.collection = collection;
	}
}
