package com.github.jira.commons.exception;

public class JiraRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public JiraRequestException() {
		super("Request to failed.");
	}
	
	public JiraRequestException(String message) {
		super(message);
	}
	
	public JiraRequestException(Exception e) {
		super(e);
	}
	
	public JiraRequestException(String message, Exception e) {
		super(message, e);
	}
}
