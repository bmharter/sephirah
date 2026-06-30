package com.fearlesstyrant.sephirah.tools.type;

import java.util.*;

import com.fearlesstyrant.sephirah.tools.FunctionSignature;

public final class SephirahTypeInferenceContext{
	private final Set<String> resolvingVariables = new HashSet<>();
	private final Set<String> resolvingFunctions = new HashSet<>();
	private final Deque<Map<String, SephirahType>> localVariableTypes = new ArrayDeque<>();
	private final Map<String, SephirahType> externalVariableTypes = new HashMap<>();
	private final Map<String, FunctionSignature> externalFunctionSignatures = new HashMap<>();
	
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
	
	public void registerExternalVariableType(String name, SephirahType type) {
		if(name == null || name.isBlank() || type == null) {
			return;
		}
		
		externalVariableTypes.put(name, type);
	}
	
	public Optional<SephirahType> findExternalVariableType(String name) {
		return Optional.ofNullable(externalVariableTypes.get(name));
	}
	
	public void registerExternalFunctionSignature(
			String name,
			FunctionSignature signature) {
		if(name == null || name.isBlank() || signature == null) {
			return;
		}
		
		externalFunctionSignatures.put(name, signature);
	}
	
	public Optional<FunctionSignature> findExternalFunctionSignature(String name) {
		return Optional.ofNullable(externalFunctionSignatures.get(name));
	}
	
	public SephirahTypeInferenceContext copyForInference() {
	    SephirahTypeInferenceContext copy =
	            new SephirahTypeInferenceContext();

	    copy.externalVariableTypes.putAll(externalVariableTypes);
	    copy.externalFunctionSignatures.putAll(externalFunctionSignatures);

	    return copy;
	}
}