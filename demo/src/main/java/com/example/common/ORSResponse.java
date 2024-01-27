package com.example.common;

import java.util.HashMap;
import java.util.Map;

public class ORSResponse {

	public static String MESSAGE = "message";
	public static String EMAIL = "email";

	private boolean success = false;

	private Map<String, Object> result = new HashMap<String, Object>();

	public ORSResponse() {
	}

	public ORSResponse(boolean success) {
		this.success = success;
	}

	public ORSResponse(boolean success, String message) {
		this.success = success;
		addMessage(message);
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void addMessage(Object value) {
		result.put(MESSAGE, value);
	}
	
	public void addEmails(Object value) {
		result.put(EMAIL, value);
	}

}
