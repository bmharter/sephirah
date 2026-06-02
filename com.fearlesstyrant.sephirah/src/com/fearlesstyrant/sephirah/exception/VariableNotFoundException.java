package com.fearlesstyrant.sephirah.exception;

@SuppressWarnings("serial")
public class VariableNotFoundException extends Exception {
	
	private static String message = "This variable has not been declared or imported.";
	
	public VariableNotFoundException() {
		super(message);
	}
}
