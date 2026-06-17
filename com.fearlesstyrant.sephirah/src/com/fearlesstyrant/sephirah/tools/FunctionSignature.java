package com.fearlesstyrant.sephirah.tools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.fearlesstyrant.sephirah.tools.value.SephirahType;

public final class FunctionSignature {

    private final int minArgs;
    private final int maxArgs;
    private final List<SephirahType> parameterTypes;
    private final SephirahType returnType;

    private FunctionSignature(
            int minArgs,
            int maxArgs,
            List<SephirahType> parameterTypes,
            SephirahType returnType) {
        this.minArgs = minArgs;
        this.maxArgs = maxArgs;
        this.parameterTypes = parameterTypes;
        this.returnType = returnType;
    }
    
    public static FunctionSignature atLeast(int minArgs) {
        return new FunctionSignature(
                minArgs,
                Integer.MAX_VALUE,
                Collections.emptyList(),
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
                returnType);
    }

    public static FunctionSignature exactly(int count) {
        return new FunctionSignature(
                count,
                count,
                Collections.emptyList(),
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
        if (index < 0 || index >= parameterTypes.size()) {
            return Optional.empty();
        }

        SephirahType type = parameterTypes.get(index);

        if (type == SephirahType.UNKNOWN) {
            return Optional.empty();
        }

        return Optional.of(type);
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
}
