package com.khandelwal.domainmodel.weather;

public class Weather {

	public Temperature temperature;
	public Wind wind;
	public Humidity humidity;

	public Weather(final Temperature temperature, final Wind wind,
			final Humidity humidity) {

		this.temperature = temperature;
		this.wind = wind;
		this.humidity = humidity;
	}

	/* TODO: Override hash and equals method */
}
