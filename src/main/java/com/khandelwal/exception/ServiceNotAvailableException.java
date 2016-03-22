package com.khandelwal.exception;

@SuppressWarnings("serial")
public class ServiceNotAvailableException extends AbstractException {

	public ServiceNotAvailableException(String errorCode,
			String errorDescription) {

		super(errorCode, errorDescription);
	}
}
