package com.khandelwal.exception.advice;

import java.util.logging.Logger;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.khandelwal.domainmodel.error.ErrorDetail;
import com.khandelwal.exception.RequestInvalidException;

@ControllerAdvice
public class RequestInvalidExceptionAdvice {

	Logger log = Logger
			.getLogger(RequestInvalidExceptionAdvice.class.getName());

	@ExceptionHandler(RequestInvalidException.class)
	public HttpEntity<ErrorDetail> requestInvalidExceptionHandler(
			RequestInvalidException requestInvalidException) {

		Link link = new Link("http://khandelwal.com");

		ErrorDetail errorDetail = new ErrorDetail(
				requestInvalidException.getErrorCode(),
				requestInvalidException.getErrorDescription());

		errorDetail.add(link);

		log.info("Exception: Utility service request is invalid");

		return new ResponseEntity<ErrorDetail>(errorDetail,
				HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(NoSuchBeanDefinitionException.class)
	public HttpEntity<ErrorDetail> noSuchBeanDefinitionExceptionHandler() {

		Link link = new Link("http://khandelwal.com");

		ErrorDetail errorDetail = new ErrorDetail ("eNSBDE","Request is invalid");

		errorDetail.add(link);

		log.info("Exception: Utility service request is invalid");

		return new ResponseEntity<ErrorDetail>(errorDetail,
				HttpStatus.BAD_REQUEST);

	}
}
