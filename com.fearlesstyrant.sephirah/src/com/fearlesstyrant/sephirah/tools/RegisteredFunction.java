package com.fearlesstyrant.sephirah.tools;

import java.util.*;

import com.fearlesstyrant.sephirah.tools.value.SephirahValue;

/**
 * A callable function with its validation metadata.
 */
public final class RegisteredFunction {

	private final String name;
	private final FunctionSignature signature;
	private final SephirahFunction function;
	
	public RegisteredFunction(
			String name,
			FunctionSignature signature,
			SephirahFunction function) {
		this.name = Objects.requireNonNull(name, "name must not be null");
		this.signature = Objects.requireNonNull(signature, "signature must not be null");
		this.function = Objects.requireNonNull(function, "function must not be null");
	}
	
	public SephirahValue invoke(List<SephirahValue> arguments, EvaluationContext context) {
        Objects.requireNonNull(arguments, "arguments must not be null");
        Objects.requireNonNull(context, "context must not be null");

        if (!signature.accepts(arguments.size())) {
            throw new IllegalArgumentException(
                    signature.describeMismatch(name, arguments.size()));
        }

        return function.apply(arguments, context);
    }

	public String getName() {
		return name;
	}

	public FunctionSignature getSignature() {
		return signature;
	}

	public SephirahFunction getFunction() {
		return function;
	}
}
