package com.fearlesstyrant.sephirah.tools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.fearlesstyrant.sephirah.tools.type.SephirahType;

public final class FunctionSignature {

    private final int minArgs;
    private final int maxArgs;
    private final List<SephirahType> parameterTypes;
    private final SephirahType returnType;
    private final SephirahType repeatedParameterType;

    private FunctionSignature(
            int minArgs,
            int maxArgs,
            List<SephirahType> parameterTypes,
            SephirahType repeatedParameterType,
            SephirahType returnType) {
        this.minArgs = minArgs;
        this.maxArgs = maxArgs;
        this.parameterTypes = parameterTypes;
        this.repeatedParameterType = repeatedParameterType;
        this.returnType = returnType;
    }
    
    public static FunctionSignature atLeast(int minArgs) {
        return new FunctionSignature(
                minArgs,
                Integer.MAX_VALUE,
                Collections.emptyList(),
                SephirahType.UNKNOWN,
                SephirahType.UNKNOWN);
    }

    public static FunctionSignature atLeast(
            int minArgs,
            SephirahType returnType,
            SephirahType... parameterTypes) {
        return new FunctionSignature(
                minArgs,
                Integer.MAX_VALUE,
                Arrays.asList(parameterTypes),
                SephirahType.UNKNOWN,
                returnType);
    }

    public static FunctionSignature exactly(int count) {
        return new FunctionSignature(
                count,
                count,
                Collections.emptyList(),
                SephirahType.UNKNOWN,
                SephirahType.UNKNOWN);
    }

    public static FunctionSignature exactly(
            int count,
            SephirahType returnType,
            SephirahType... parameterTypes) {
        return new FunctionSignature(
                count,
                count,
                Arrays.asList(parameterTypes),
                SephirahType.UNKNOWN,
                returnType);
    }

    public boolean accepts(int actual) {
        return actual >= minArgs && actual <= maxArgs;
    }

    public Optional<SephirahType> getReturnType() {
        if (returnType == SephirahType.UNKNOWN) {
            return Optional.empty();
        }

        return Optional.of(returnType);
    }

    public Optional<SephirahType> getParameterType(int index) {
        if (index < 0) {
            return Optional.empty();
        }
        
        if(index < parameterTypes.size()) {
        	SephirahType type = parameterTypes.get(index);

            if (type == SephirahType.UNKNOWN) {
                return Optional.empty();
            }

            return Optional.of(type);
        }
        
        if(repeatedParameterType == SephirahType.UNKNOWN) {
        	return Optional.empty();
        }
        
        return Optional.of(repeatedParameterType);
    }

    public String describeMismatch(String name, int actual) {
    	if (maxArgs == Integer.MAX_VALUE) {
            return "Function " + name + " expects at least " + minArgs
                    + " argument(s), but got " + actual + ".";
        }
    	
        if (minArgs == maxArgs) {
            return "Function " + name + " expects " + minArgs
                    + " argument(s), but got " + actual + ".";
        }

        return "Function " + name + " expects between " + minArgs
                + " and " + maxArgs + " arguments, but got " + actual + ".";
    }

	public SephirahType getRepeatedParameterType() {
		return repeatedParameterType;
	}
	
	public static FunctionSignature varargs(
			int minArgs,
			SephirahType returnType,
			SephirahType repeatedParameterType) {
		return new FunctionSignature(
				minArgs,
				Integer.MAX_VALUE,
				Collections.emptyList(),
				repeatedParameterType,
				returnType);
	}
}
