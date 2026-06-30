package com.fearlesstyrant.sephirah.tools.compile;

import java.util.*;

public final class CompiledSephirahModuleSet {

	private final Map<String, CompiledSephirahModule> modules;
	
	public CompiledSephirahModuleSet(Collection<CompiledSephirahModule> modules) {
		Map<String, CompiledSephirahModule> byName = new LinkedHashMap<>();
		
		for(CompiledSephirahModule module : modules) {
			byName.put(module.getName(), module);
		}
		
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
}
