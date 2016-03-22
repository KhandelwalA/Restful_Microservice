package com.khandelwal.exception;

@SuppressWarnings("serial")
public class RequestInvalidException extends AbstractException {

	public RequestInvalidException(String errorCode, String errorDescription) {

		super(errorCode, errorDescription);
	}

}
