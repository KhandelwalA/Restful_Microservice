package com.khandelwal.domainmodel.error;

import org.springframework.hateoas.ResourceSupport;

public class ErrorDetail extends ResourceSupport{

	public String errorCode;
	public String errorDescription;

	public ErrorDetail(String errorCode, String errorDescription) {
		
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	
}
