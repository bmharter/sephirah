package com.fearlesstyrant.sephirah.tools;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Holds the currently active function registry while module functions and
 * module variables are being wired together.
 *
 * <p>This resolves the construction cycle between ModuleValueResolver and the
 * compiled module FunctionRegistry.</p>
 */
public class MutableFunctionRegistryReference implements Supplier<FunctionRegistry> {

	private FunctionRegistry registry;
	
	public MutableFunctionRegistryReference(FunctionRegistry initialRegistry) {
        this.registry = Objects.requireNonNull(initialRegistry, "initialRegistry must not be null");
    }
	
	public void set(FunctionRegistry registry) {
		this.registry = Objects.requireNonNull(registry, "registry must not be null");
	}
	
	@Override
	public FunctionRegistry get() {
		return registry;
	}

}
