package com.khandelwal.exception.advice;

import java.util.logging.Logger;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.khandelwal.domainmodel.error.ErrorDetail;
import com.khandelwal.exception.ServiceNotAvailableException;

@ControllerAdvice
public class ServiceNotAvailableExceptionAdvice {

	private final Logger log = Logger
			.getLogger(ServiceNotAvailableExceptionAdvice.class.getName());

	@ExceptionHandler(ServiceNotAvailableException.class)
	public HttpEntity<ErrorDetail> serviceNotAvailableExceptionHandler(
			ServiceNotAvailableException serviceNotAvailableException) {

		Link link = new Link("http://khandelwal.com");

		ErrorDetail errorDetail = new ErrorDetail(
				serviceNotAvailableException.getErrorCode(),
				serviceNotAvailableException.getErrorDescription());

		errorDetail.add(link);

		log.info("Exception: Utility service is not available");

		return new ResponseEntity<ErrorDetail>(errorDetail,
				HttpStatus.SERVICE_UNAVAILABLE);
	}
}
