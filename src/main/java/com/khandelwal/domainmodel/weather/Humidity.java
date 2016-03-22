package com.khandelwal.domainmodel.weather;

public class Humidity {

	public long value;
	public String unit;

	public Humidity(final long value, final String unit) {

		this.value = value;
		this.unit = unit;
	}

	/* TODO overide hash and equals method */

}
