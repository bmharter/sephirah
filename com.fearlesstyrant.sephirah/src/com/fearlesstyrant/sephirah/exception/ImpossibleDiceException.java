package com.fearlesstyrant.sephirah.exception;

public class ImpossibleDiceException extends Exception {

	private static final long serialVersionUID = -6573861946530679016L;
	private static String message = "Dice parameters must be positive integers.";
	
	public ImpossibleDiceException() {
		super(message);
	}
}
