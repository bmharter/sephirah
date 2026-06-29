package com.fearlesstyrant.sephirah.tools.compile;

import com.fearlesstyrant.sephirah.tools.FunctionSignature;

public final class CompiledFunction {

	private final String name;
	private final FunctionSignature signature;
	
	public CompiledFunction(String name, FunctionSignature signature) {
		this.name = name;
		this.signature = signature;
	}

	public String getName() {
		return name;
	}

	public FunctionSignature getSignature() {
		return signature;
	}
}
