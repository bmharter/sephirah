package com.fearlesstyrant.sephirah.tools;

import java.math.BigDecimal;
import java.util.*;

import com.fearlesstyrant.sephirah.sephirah.*;
import com.fearlesstyrant.sephirah.tools.value.SephirahValue;

public final class ModuleEvaluator {

	private final FormulaModel model;
    private final FunctionRegistry functions;
    private final ModuleValueResolver resolver;
    private final EvaluationContext context;
    private final Computer computer;
    
    /**
     * Creates a module evaluator using Sephirah's standard function registry.
     *
     * @param model Sephirah module/document model
     */
    public ModuleEvaluator(FormulaModel model) {
        this(model, Methods.standardRegistry());
    }
    
    /**
     * Creates a module evaluator using the supplied function registry.
     *
     * @param model Sephirah module/document model
     * @param functions functions available during evaluation
     */
    public ModuleEvaluator(FormulaModel model, FunctionRegistry functions) {
    	this.model = Objects.requireNonNull(model, "model must not be null");
    	
    	FunctionRegistry baseFunctions =
    	        Objects.requireNonNull(functions, "functions must not be null");
    	
    	MutableFunctionRegistryReference functionReference =
    			new MutableFunctionRegistryReference(baseFunctions);

    	this.resolver = new ModuleValueResolver(this.model, functionReference);
    	this.functions = ModuleFunctionCompiler.compile(model,
    			baseFunctions,
    			resolver,
    			functionReference);
    	
    	functionReference.set(this.functions);
    	
    	this.context = new EvaluationContext(Collections.emptyMap(), resolver);
    	this.computer = new Computer(context, this.functions);
    }
    
    /**
     * Evaluates a single expression inside this module's context.
     *
     * @param expression expression to evaluate
     * @return evaluated numeric result
     */
    public BigDecimal evaluate(Expression expression) {
    	Objects.requireNonNull(expression, "expression must not be null");
    	
    	return computer.evaluate(expression);
    }
    
    /**
     * Evaluates an Evaluation statement inside this module's context.
     *
     * @param evaluation evaluation statement to evaluate
     * @return evaluated numeric result
     */
    public BigDecimal evaluate(Evaluation evaluation) {
    	Objects.requireNonNull(evaluation, "evaluation must not be null");
    	
    	return evaluate(evaluation.getExpression());
    }
    
    public SephirahValue evaluateValue(Expression expression) {
        return computer.evaluateValue(expression);
    }
    
    /**
     * Evaluates all top-level evaluation statements in source/model order.
     *
     * @return evaluated results
     */
    public List<BigDecimal> evaluateAll() {
    	List<BigDecimal> results = new ArrayList<>();
    	
    	for(Evaluation evaluation : model.getValues()) {
    		results.add(evaluate(evaluation));
    	}
    	
    	return results;
    }

    /**
     * Returns the function registry used by this evaluator.
     *
     * @return function registry
     */
	public FunctionRegistry getFunctions() {
		return functions;
	}

	/**
     * Returns the module resolver used by this evaluator.
     *
     * @return module value resolver
     */
	public ModuleValueResolver getResolver() {
		return resolver;
	}

	/**
     * Returns the evaluation context used by this evaluator.
     *
     * @return evaluation context
     */
	public EvaluationContext getContext() {
		return context;
	}
}
