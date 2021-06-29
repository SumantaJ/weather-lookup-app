package com.weather.lookup.app.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.weather.lookup.app.domain.ApiMessage;


@ControllerAdvice
public class GlobalControllerAdvice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ApiMessage exceptionHandlerIllegalArgumentException(final IllegalArgumentException e) {
		return getApiErrorMessage(e.getMessage());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ApiMessage exceptionHandlerSecurityException(final Exception e) {
		return getApiErrorMessage(e.getMessage());
	}
	
	private ApiMessage getApiErrorMessage(String message) {
		return new ApiMessage(message);
	}
}
