package com.fearlesstyrant.sephirah.tools.type;

import java.util.*;

import org.eclipse.xtext.EcoreUtil2;

import com.fearlesstyrant.sephirah.sephirah.Add;
import com.fearlesstyrant.sephirah.sephirah.AndCondition;
import com.fearlesstyrant.sephirah.sephirah.Assignment;
import com.fearlesstyrant.sephirah.sephirah.BooleanLiteral;
import com.fearlesstyrant.sephirah.sephirah.ComparisonCondition;
import com.fearlesstyrant.sephirah.sephirah.Conditional;
import com.fearlesstyrant.sephirah.sephirah.Constant;
import com.fearlesstyrant.sephirah.sephirah.Definition;
import com.fearlesstyrant.sephirah.sephirah.Divide;
import com.fearlesstyrant.sephirah.sephirah.Exponent;
import com.fearlesstyrant.sephirah.sephirah.Expression;
import com.fearlesstyrant.sephirah.sephirah.FormulaModel;
import com.fearlesstyrant.sephirah.sephirah.MethodCall;
import com.fearlesstyrant.sephirah.sephirah.Multiply;
import com.fearlesstyrant.sephirah.sephirah.Negate;
import com.fearlesstyrant.sephirah.sephirah.NotCondition;
import com.fearlesstyrant.sephirah.sephirah.NumberLiteral;
import com.fearlesstyrant.sephirah.sephirah.OrCondition;
import com.fearlesstyrant.sephirah.sephirah.Subtract;
import com.fearlesstyrant.sephirah.sephirah.Variable;
import com.fearlesstyrant.sephirah.sephirah.VariableAssignment;
import com.fearlesstyrant.sephirah.tools.FunctionSignature;
import com.fearlesstyrant.sephirah.tools.Methods;

public final class SephirahTypeInferencer {

	private SephirahTypeInferencer() {
		
	}
	
	public static SephirahType inferType(Expression expression) {
        return inferType(expression, SephirahTypeInferenceContext.empty());
    }
	
	public static SephirahType inferType(Expression expression,
			SephirahTypeInferenceContext context) {
		if(expression == null) {
			return SephirahType.UNKNOWN;
		}
		
		if(expression instanceof NumberLiteral || expression instanceof Constant) {
			return SephirahType.NUMBER;
		}
		
		if(expression instanceof BooleanLiteral) {
			return SephirahType.BOOLEAN;
		}
		
		if(expression instanceof Add add) {
			return inferNumericBinaryType(add.getLeft(), add.getRight(), context);
		}
		
		if(expression instanceof Subtract subtract) {
			return inferNumericBinaryType(subtract.getLeft(), subtract.getRight(), context);
		}
		
		if(expression instanceof Multiply multiply) {
			return inferNumericBinaryType(multiply.getLeft(), multiply.getRight(), context);
		}
		
		if(expression instanceof Divide divide) {
			return inferNumericBinaryType(divide.getLeft(), divide.getRight(), context);
		}
		
		if(expression instanceof Exponent exponent) {
			return inferNumericBinaryType(exponent.getLeft(), exponent.getRight(), context);
		}
		
		if(expression instanceof Negate negate) {
			SephirahType valueType = inferType(negate.getValue(), context);
			
			if(valueType != SephirahType.NUMBER) {
				return SephirahType.UNKNOWN;
			}
			
			return valueType;
		}
		
		if (expression instanceof ComparisonCondition comparison) {
		    SephirahType leftType = inferType(comparison.getLeft(), context);
		    SephirahType rightType = inferType(comparison.getRight(), context);

		    if (leftType != SephirahType.NUMBER || rightType != SephirahType.NUMBER) {
		        return SephirahType.UNKNOWN;
		    }

		    return SephirahType.BOOLEAN;
		}

		if (expression instanceof AndCondition andCondition) {
		    return inferBooleanBinaryType(
		            andCondition.getLeft(),
		            andCondition.getRight(),
		            context);
		}

		if (expression instanceof OrCondition orCondition) {
		    return inferBooleanBinaryType(
		            orCondition.getLeft(),
		            orCondition.getRight(),
		            context);
		}

		if (expression instanceof NotCondition notCondition) {
		    SephirahType conditionType = inferType(notCondition.getCondition(), context);

		    if (conditionType != SephirahType.BOOLEAN) {
		        return SephirahType.UNKNOWN;
		    }

		    return SephirahType.BOOLEAN;
		}
		
		if(expression instanceof Conditional conditional) {
			SephirahType thenType = inferType(conditional.getThenBranch(), context);
			SephirahType elseType = inferType(conditional.getElseBranch(), context);
			
			if(thenType == elseType) {
				return thenType;
			}
			
			return SephirahType.UNKNOWN;
		}
		
		if(expression instanceof Variable variable) {
			return inferVariableType(variable, context);
		}
		
		if(expression instanceof MethodCall methodCall) {
	        return inferFunctionCallType(methodCall, context);
	    }

	    return SephirahType.UNKNOWN;
	}
	
	public static SephirahTypeInferenceContext freshTypeContext() {
	    return new SephirahTypeInferenceContext();
	}
	
	private static Definition findDefinition(FormulaModel model, String name) {
		for(Definition definition : model.getMethodDefs()) {
			if(name.equals(definition.getName())) {
				return definition;
			}
		}
		
		return null;
	}
	
	private static SephirahType inferFunctionCallType(
			MethodCall methodCall,
			SephirahTypeInferenceContext context) {
	
		String name = methodCall.getName();
		
		if(name == null || name.isBlank()) {
			return SephirahType.UNKNOWN;
		}
		
		FunctionSignature builtInSignature = Methods.standardRegistry().getSignature(name);
		
		if (builtInSignature != null) {
	        return builtInSignature.getReturnType()
	                .orElse(SephirahType.UNKNOWN);
	    }
		
		Optional<FunctionSignature> externalSignature =
				context.findExternalFunctionSignature(name);
		
		if(externalSignature.isPresent()) {
			return externalSignature.get()
					.getReturnType()
					.orElse(SephirahType.UNKNOWN);
		}

	    if (!context.beginResolvingFunction(name)) {
	        return SephirahType.UNKNOWN;
	    }
		
	    try {
	    	FormulaModel model = EcoreUtil2.getContainerOfType(methodCall, FormulaModel.class);
			
			if(model == null) {
				return SephirahType.UNKNOWN;
			}
			
			Definition definition = findDefinition(model, name);
			
			if(definition == null || definition.getExpr() == null) {
				return SephirahType.UNKNOWN;
			}
			
			if(definition.getArgs().size() != methodCall.getArgs().size()) {
				return SephirahType.UNKNOWN;
			}
			
			Map<String, SephirahType> parameterTypes = new HashMap<>();
			
			for(int i = 0; i < methodCall.getArgs().size(); i++) {
				Assignment parameter = definition.getArgs().get(i);
				Expression argument = methodCall.getArgs().get(i);
				
				String parameterName = parameter.getName();
				
				if(parameterName == null || parameterName.isBlank()) {
					continue;
				}
				
				parameterTypes.put(parameterName, inferType(argument, context));
			}
			
			context.pushLocalVariableTypes(parameterTypes);
			
			try {
				return inferType(definition.getExpr(), context);
			} finally {
				context.popLocalVariableTypes();
			}
	    } finally {
	    	context.endResolvingFunction(name);
	    }
	}

	private static SephirahType inferBooleanBinaryType(
	        Expression left,
	        Expression right,
	        SephirahTypeInferenceContext context) {

	    SephirahType leftType = inferType(left, context);
	    SephirahType rightType = inferType(right, context);

	    if (leftType != SephirahType.BOOLEAN || rightType != SephirahType.BOOLEAN) {
	        return SephirahType.UNKNOWN;
	    }

	    return SephirahType.BOOLEAN;
	}
	
	private static SephirahType inferNumericBinaryType(Expression left,
			Expression right,
			SephirahTypeInferenceContext context) {
		SephirahType leftType = inferType(left, context);
		SephirahType rightType = inferType(right, context);
		
		if(leftType != SephirahType.NUMBER || rightType != SephirahType.NUMBER) {
			return SephirahType.UNKNOWN;
		}
		
		return SephirahType.NUMBER;
	}
	
	private static SephirahType inferVariableType(Variable variable,
			SephirahTypeInferenceContext context) {
		String name = variable.getName();
		
		if (name == null || name.isBlank()) {
		    return SephirahType.UNKNOWN;
		}

		Optional<SephirahType> externalType =
		        context.findExternalVariableType(name);

		if (externalType.isPresent()) {
		    return externalType.get();
		}

		if (name.contains(".")) {
		    return SephirahType.UNKNOWN;
		}
		
		Optional<SephirahType> localType = context.findLocalVariableType(name);
		
		if(localType.isPresent()) {
			return localType.get();
		}
		
		if(!context.beginResolvingVariable(name)) {
			return SephirahType.UNKNOWN;
		}
		
		try {
			FormulaModel model = EcoreUtil2.getContainerOfType(variable, FormulaModel.class);
			
			if(model == null) {
				return SephirahType.UNKNOWN;
			}
			
			for(Assignment assignment : model.getVariables()) {
				if(assignment instanceof VariableAssignment variableAssignment
						&& name.equals(variableAssignment.getName())) {
					return inferType(variableAssignment.getValue(), context);
				}
			}
			
			return SephirahType.UNKNOWN;
		} finally {
			context.endResolvingVariable(name);
		}
	}
}
