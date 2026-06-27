package com.fearlesstyrant.sephirah.tools.type;

import java.util.*;

public final class SephirahTypeInferenceContext{
	private final Set<String> resolvingVariables = new HashSet<>();
	private final Set<String> resolvingFunctions = new HashSet<>();
	private final Deque<Map<String, SephirahType>> localVariableTypes = new ArrayDeque<>();
	
	public SephirahTypeInferenceContext() {
		
	}
	
	public static SephirahTypeInferenceContext empty() {
		return new SephirahTypeInferenceContext();
	}
	
	public boolean beginResolvingVariable(String name) {
		return resolvingVariables.add(name);
	}
	
	public void endResolvingVariable(String name) {
		resolvingVariables.remove(name);
	}
	
	public boolean beginResolvingFunction(String name) {
		return resolvingFunctions.add(name);
	}
	
	public void endResolvingFunction(String name) {
		resolvingFunctions.remove(name);
	}
	
	public void pushLocalVariableTypes(Map<String, SephirahType> types) {
		localVariableTypes.push(new HashMap<>(types));
	}
	
	public void popLocalVariableTypes() {
		localVariableTypes.pop();
	}
	
	public Optional<SephirahType> findLocalVariableType(String name) {
        for (Map<String, SephirahType> scope : localVariableTypes) {
            SephirahType type = scope.get(name);

            if (type != null) {
                return Optional.of(type);
            }
        }

        return Optional.empty();
    }
}