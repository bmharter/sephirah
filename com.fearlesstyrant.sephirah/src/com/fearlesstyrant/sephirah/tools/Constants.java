package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;

public class Constants {

	private static final double PI = 3.14159265358979;
	private static final double BIG_G = 0.0000000000667430;
	private static final double PHI = 1.61803398874989484820;
	private static final double E = 2.71828182845904523536;
	private static final double GAMMA = 0.57721566490153286060;
	
	public static double getConstant(String value) {
		switch(value) {
		case "pi":
			return getPi();
		
		case "G":
			return getBigG();
			
		case "phi":
			return getPhi();
			
		case "gamma":
			return getGamma();
			
		case "e":
			return getE();
			
		default:
			return 0.0;
		}
	}
	
	public static BigDecimal getBDConstant(String value) {
		return new BigDecimal(getConstant(value));
	}
	
	private static double getPi() {
		return PI;
	}
	private static double getBigG() {
		return BIG_G;
	}
	private static double getPhi() {
		return PHI;
	}
	private static double getE() {
		return E;
	}
	private static double getGamma() {
		return GAMMA;
	}
}
