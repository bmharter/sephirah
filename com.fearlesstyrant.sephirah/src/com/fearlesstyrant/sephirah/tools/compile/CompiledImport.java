package com.fearlesstyrant.sephirah.tools.compile;

public final class CompiledImport {

	private final String moduleName;
	private final String alias;
	
	public CompiledImport(
			String moduleName,
			String alias) {
		this.moduleName = moduleName;
		this.alias = alias;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getAlias() {
		return alias;
	}
	
	public String getLocalName() {
		if(alias == null || alias.isBlank()) {
			return moduleName;
		}
		
		return alias;
	}
}
