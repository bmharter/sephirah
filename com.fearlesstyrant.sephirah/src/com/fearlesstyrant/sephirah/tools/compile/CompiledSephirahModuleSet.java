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
		validateImportCycles(byName);
		
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
	
	private static void validateImportCycles(
	        Map<String, CompiledSephirahModule> modules) {
	    Set<String> visited = new HashSet<>();
	    Deque<String> stack = new ArrayDeque<>();

	    for (String moduleName : modules.keySet()) {
	        checkImportCycle(moduleName, modules, visited, stack);
	    }
	}

	private static void checkImportCycle(
	        String moduleName,
	        Map<String, CompiledSephirahModule> modules,
	        Set<String> visited,
	        Deque<String> stack) {
	    if (stack.contains(moduleName)) {
	        throw new IllegalArgumentException(
	                "Cyclic Sephirah module import: "
	                + formatImportCycle(moduleName, stack));
	    }

	    if (visited.contains(moduleName)) {
	        return;
	    }

	    CompiledSephirahModule module = modules.get(moduleName);

	    if (module == null) {
	        return;
	    }

	    stack.push(moduleName);

	    try {
	        for (CompiledImport imported : module.getImports()) {
	            checkImportCycle(
	                    imported.getModuleName(),
	                    modules,
	                    visited,
	                    stack);
	        }

	        visited.add(moduleName);
	    } finally {
	        stack.pop();
	    }
	}

	private static String formatImportCycle(
	        String repeatedName,
	        Deque<String> stack) {
	    List<String> path = new ArrayList<>(stack);
	    Collections.reverse(path);

	    int cycleStart = path.indexOf(repeatedName);

	    StringBuilder builder = new StringBuilder();

	    if (cycleStart >= 0) {
	        for (int i = cycleStart; i < path.size(); i++) {
	            if (builder.length() > 0) {
	                builder.append(" -> ");
	            }

	            builder.append(path.get(i));
	        }

	        builder.append(" -> ").append(repeatedName);
	        return builder.toString();
	    }

	    builder.append(repeatedName);

	    for (String name : path) {
	        builder.append(" -> ").append(name);
	    }

	    builder.append(" -> ").append(repeatedName);

	    return builder.toString();
	}
}
