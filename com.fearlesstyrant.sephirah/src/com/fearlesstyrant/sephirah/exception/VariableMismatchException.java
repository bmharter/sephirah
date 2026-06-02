package com.fearlesstyrant.sephirah.exception;

public class VariableMismatchException extends Exception {

	private static final long serialVersionUID = 6321277124017216814L;
	private static String message = "The given Variable's name is not found in the DefinitionParameterList.";
	
	public VariableMismatchException() {
		super(message);
	}
}
