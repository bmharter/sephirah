package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;

import javax.naming.spi.Resolver;

import com.fearlesstyrant.sephirah.tools.ValueResolver;
import com.fearlesstyrant.sephirah.tools.value.SephirahValue;

public final class ImportAwareValueResolver implements ValueResolver {

	private final ValueResolver localResolver;
	private final Map<String, CompiledSephirahModule> importedModulesByLocalName;
	
	public ImportAwareValueResolver(
			ValueResolver localResolver,
			Map<String, CompiledSephirahModule> importedModulesByLocalName) {
		this.localResolver = localResolver;
		this.importedModulesByLocalName = new HashMap<>(importedModulesByLocalName);
	}
	
	@Override
	public Optional<SephirahValue> resolveValue(String name) {
		Optional<SephirahValue> localValue = localResolver.resolveValue(name);
		
		if(localValue.isPresent()) {
			return localValue;
		}
		
		int dot = name.indexOf('.');
		
		if(dot < 0) {
			return Optional.empty();
		}
		
		String moduleLocalName = name.substring(0, dot);
		String variableName = name.substring(dot + 1);
		
		CompiledSephirahModule localModule =
				importedModulesByLocalName.get(moduleLocalName);
		
		if(localModule == null) {
			return Optional.empty();
		}
		
		if(!localModule.getExports().hasVariable(variableName)) {
			return Optional.empty();
		}
		
		return Optional.of(localModule.evaluateVariable(variableName));
	}
}
