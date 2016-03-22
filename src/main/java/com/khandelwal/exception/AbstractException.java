package com.khandelwal.exception;

@SuppressWarnings("serial")
public abstract class AbstractException extends RuntimeException {

	public String errorCode;
	public String errorDescription;

	public AbstractException(String errorCode, String errorDescription) {

		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

}
