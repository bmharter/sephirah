package com.fearlesstyrant.sephirah.tools;

import java.util.Objects;

/**
 * Describes the argument-count rules for a Sephirah function.
 */
public final class FunctionSignature {

	private final Integer minimumArity;
	private final Integer maximumArity;
	
	private FunctionSignature(Integer minimumArity, Integer maximumArity) {
		this.minimumArity = minimumArity;
		this.maximumArity = maximumArity;
	}
	
	/**
     * Creates a fixed-arity signature.
     *
     * @param arity exact number of arguments required
     * @return function signature
     */
    public static FunctionSignature exactly(int arity) {
        if (arity < 0) {
            throw new IllegalArgumentException("arity must not be negative");
        }

        return new FunctionSignature(arity, arity);
    }
    
    /**
     * Creates a signature accepting at least the supplied number of arguments.
     *
     * @param minimumArity minimum number of arguments required
     * @return function signature
     */
    public static FunctionSignature atLeast(int minimumArity) {
        if (minimumArity < 0) {
            throw new IllegalArgumentException("minimumArity must not be negative");
        }

        return new FunctionSignature(minimumArity, null);
    }
    
    /**
     * Checks whether an argument count is accepted by this signature.
     *
     * @param actualArity actual number of supplied arguments
     * @return true when valid
     */
    public boolean accepts(int actualArity) {
        if (actualArity < 0) {
            return false;
        }

        if (minimumArity != null && actualArity < minimumArity) {
            return false;
        }

        if (maximumArity != null && actualArity > maximumArity) {
            return false;
        }

        return true;
    }
    
    /**
     * Builds a user-facing error message.
     *
     * @param functionName function name
     * @param actualArity actual supplied argument count
     * @return error message
     */
    public String describeMismatch(String functionName, int actualArity) {
        Objects.requireNonNull(functionName, "functionName must not be null");

        if (minimumArity != null && maximumArity != null
                && minimumArity.equals(maximumArity)) {
            return "Function " + functionName + " expects " + minimumArity
                    + " argument(s), but received " + actualArity + ".";
        }

        if (minimumArity != null && maximumArity == null) {
            return "Function " + functionName + " expects at least " + minimumArity
                    + " argument(s), but received " + actualArity + ".";
        }

        return "Function " + functionName + " received invalid argument count: "
                + actualArity + ".";
    }

    public Integer getMinimumArity() {
        return minimumArity;
    }

    public Integer getMaximumArity() {
        return maximumArity;
    }
}
