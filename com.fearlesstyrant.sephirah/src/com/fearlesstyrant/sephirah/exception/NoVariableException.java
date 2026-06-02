package com.fearlesstyrant.sephirah.exception;

public class NoVariableException extends Exception {

	private static final long serialVersionUID = 106710029109234024L;
	public static String message = "No variable was found in this expression.";
	
	public NoVariableException() {
		super(message);
	}
}
