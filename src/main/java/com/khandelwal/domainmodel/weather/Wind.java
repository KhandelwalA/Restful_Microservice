package com.khandelwal.domainmodel.weather;

public class Wind {

	public double speed;
	public long deg;

	public Wind(final double speed, final long deg) {

		this.speed = speed;
		this.deg = deg;
	}

	/* TODO: Override equals and hash methods */
}
