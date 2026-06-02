package com.fearlesstyrant.sephirah.exception;

import com.fearlesstyrant.sephirah.sephirah.*;
public class NoNumberException extends Exception {

	private static final long serialVersionUID = 5421653630627828186L;
	private static String message = "No values have been stored in this Expression object.";
	
	public NoNumberException(Expression expr) {
		super(message);
	}
}
