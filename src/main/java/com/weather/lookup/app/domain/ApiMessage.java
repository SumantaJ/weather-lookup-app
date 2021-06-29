package com.weather.lookup.app.domain;

/**
 * Base message response
 */
public class ApiMessage {

	private String message;
	private String[] error;

	public ApiMessage(String message) {
		this.message = message;
		this.error = new String[0];
	}

	public ApiMessage(String message, String[] error) {
		this.message = message;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public String[] getError() {
		return error;
	}
}
