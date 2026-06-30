package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;

public final class CompiledSephirahModuleSet {

	private final Map<String, CompiledSephirahModule> modules;
	
	public CompiledSephirahModuleSet(Collection<CompiledSephirahModule> modules) {
		Map<String, CompiledSephirahModule> byName = new LinkedHashMap<>();
		
		for(CompiledSephirahModule module : modules) {
			String name = module.getName();
			
			if(byName.containsKey(name)) {
				throw new IllegalArgumentException(
		                "Duplicate Sephirah module name: " + name);
			}
			
			byName.put(name, module);
		}
		
		validateImports(byName);
		
		this.modules = Map.copyOf(byName);
	}

	public Collection<CompiledSephirahModule> getModules() {
		return modules.values();
	}
	
	public boolean hasModule(String name) {
		return modules.containsKey(name);
	}
	
	public CompiledSephirahModule getModule(String name) {
		CompiledSephirahModule module = modules.get(name);

        if (module == null) {
            throw new IllegalArgumentException("Unknown module: " + name);
        }

        return module;
	}
	
	public Set<String> getModuleNames() {
		return Collections.unmodifiableSet(modules.keySet());
	}
	
	public int size() {
		return modules.size();
	}
	
	private static void validateImports(
	        Map<String, CompiledSephirahModule> modules) {
	    for (CompiledSephirahModule module : modules.values()) {
	        for (CompiledImport imported : module.getImports()) {
	            if (!modules.containsKey(imported.getModuleName())) {
	                throw new IllegalArgumentException(
	                        "Module " + module.getName()
	                        + " imports unknown module: "
	                        + imported.getModuleName());
	            }
	        }
	    }
	}
}
