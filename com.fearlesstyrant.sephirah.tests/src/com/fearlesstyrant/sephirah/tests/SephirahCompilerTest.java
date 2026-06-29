package com.fearlesstyrant.sephirah.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.fearlesstyrant.sephirah.sephirah.FormulaModel;
import com.fearlesstyrant.sephirah.tools.value.SephirahValue;
import com.fearlesstyrant.sephirah.tools.value.SephirahValues;
import com.fearlesstyrant.sephirah.tools.FunctionSignature;
import com.fearlesstyrant.sephirah.tools.compile.*;
import com.fearlesstyrant.sephirah.tools.type.SephirahType;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(SephirahInjectorProvider.class)
public class SephirahCompilerTest {

    @Inject
    private ParseHelper<FormulaModel> parseHelper;

    @Test
    public void compiledVariableCanUseUserFunction() throws Exception {
        FormulaModel model = parseHelper.parse("""
                SephirahDoc compileUserFunctionVariableSmoke

                def addOne(x) = x + 1;

                var score = addOne(4);

                score;
                """);

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                "5",
                module.evaluateVariable("score").toString());
    }
    
    @Test
    public void compiledModuleCanCallUserFunctionDirectly() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileDirectFunctionCallSmoke\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                "5",
                module.call(
                        "add",
                        List.of(
                                SephirahValues.numeric(BigDecimal.valueOf(2)),
                                SephirahValues.numeric(BigDecimal.valueOf(3))))
                        .toString());
    }
    
    @Test
    public void compiledModuleCanEvaluateBooleanVariable() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileBooleanVariableSmoke\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n\n"
              + "eligible;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                "true",
                module.evaluateVariable("eligible").toString());
    }
    
    @Test
    public void compiledModuleCanCallUserFunctionWithNumberConvenienceMethod() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileConvenienceNumberCall\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                "5",
                module.callForNumber("add", 2, 3).toString());
    }
    
    @Test
    public void compiledModuleCanEvaluateBooleanVariableWithConvenienceMethod() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileConvenienceBooleanVariable\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                true,
                module.evaluateBooleanVariable("eligible"));
    }
    
    @Test
    public void compiledModuleCanCallBooleanFunctionWithBooleanConvenienceMethod() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileConvenienceBooleanCall\n\n"
              + "def invert(flag) = not flag;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                true,
                module.callForBoolean("invert", false));
    }
    
    @Test
    public void compiledModuleCanCallTwoBooleanFunctionWithBooleanConvenienceMethod() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileConvenienceTwoBooleanCall\n\n"
              + "def both(left, right) = left and right;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                false,
                module.callForBoolean("both", true, false));
    }
    
    @Test
    public void compiledModuleCanCallMixedArgumentFunctionReturningNumber() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileMixedArgumentsNumber\n\n"
              + "def choose(flag, yesValue, noValue) = if flag then yesValue else noValue;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                "10",
                module.callForNumberWithJavaValues("choose", true, 10, 5).toString());
    }
    
    @Test
    public void compiledModuleCanCallMixedArgumentFunctionReturningBoolean() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileMixedArgumentsBoolean\n\n"
              + "def gate(score, override) = score >= 10 or override;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                true,
                module.callForBooleanWithJavaValues("gate", 5, true));
    }
    
    @Test
    public void compiledModuleExposesVariableNames() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileVariableNames\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                true,
                module.getVariableNames().contains("score"));

        assertEquals(
                true,
                module.getVariableNames().contains("eligible"));
    }
    
    @Test
    public void compiledModuleCanReportFunctionPresence() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileFunctionPresence\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(true, module.hasFunction("add"));
        assertEquals(true, module.hasFunction("abs"));
        assertEquals(false, module.hasFunction("missing"));
    }
    
    @Test
    public void compiledModuleCanEvaluateAllEvaluationEntries() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileEvaluationEntries\n\n"
              + "var score = 10;\n"
              + "def add(a, b) = a + b;\n\n"
              + "score;\n"
              + "score >= 10;\n"
              + "add(2, 3);\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        List<SephirahValue> results = module.evaluateAll();

        assertEquals("10", results.get(0).toString());
        assertEquals("true", results.get(1).toString());
        assertEquals("5", results.get(2).toString());
        assertEquals(3, module.getEvaluationCount());
    }
    
    @Test
    public void compiledModuleCanReturnStructuredEvaluationResults() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileStructuredEvaluationResults\n\n"
              + "var score = 10;\n"
              + "def add(a, b) = a + b;\n\n"
              + "score;\n"
              + "score >= 10;\n"
              + "add(2, 3);\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        List<CompiledEvaluationResult> results =
                module.evaluateAllResults();

        assertEquals(3, results.size());

        assertEquals(0, results.get(0).getIndex());
        assertEquals("10", results.get(0).getValue().toString());

        assertEquals(1, results.get(1).getIndex());
        assertEquals("true", results.get(1).getValue().toString());

        assertEquals(2, results.get(2).getIndex());
        assertEquals("5", results.get(2).getValue().toString());
    }
    
    @Test
    public void compiledModuleCanReportNumberVariableType() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileNumberVariableType\n\n"
              + "var score = 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                SephirahType.NUMBER,
                module.getVariableType("score"));
    }
    
    @Test
    public void compiledModuleCanReportBooleanVariableType() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileBooleanVariableType\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(
                SephirahType.BOOLEAN,
                module.getVariableType("eligible"));
    }
    
    @Test
    public void compiledModuleThrowsForMissingVariableType() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileMissingVariableType\n\n"
              + "var score = 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        try {
            module.getVariableType("missing");
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Unknown variable: missing",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for missing variable type.");
    }
    
    @Test
    public void compiledModuleCanReportBuiltinFunctionSignature() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileBuiltinFunctionSignature\n\n"
              + "abs(-5);\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        FunctionSignature signature =
                module.getFunctionSignature("abs");

        assertEquals(
                SephirahType.NUMBER,
                signature.getReturnType().get());

        assertEquals(
                SephirahType.NUMBER,
                signature.getParameterType(0).get());
    }
    
    @Test
    public void compiledModuleThrowsForMissingFunctionSignature() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileMissingFunctionSignature\n\n"
              + "var score = 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        try {
            module.getFunctionSignature("missing");
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Unknown function: missing",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for missing function signature.");
    }
    
    @Test
    public void compiledModuleCanReportUserFunctionAritySignature() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileUserFunctionSignature\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        FunctionSignature signature =
                module.getFunctionSignature("add");

        assertEquals(true, signature.accepts(2));
        assertEquals(false, signature.accepts(1));
        assertEquals(false, signature.accepts(3));
    }
    
    @Test
    public void compiledEvaluationResultsIncludeInferredTypes() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileEvaluationResultTypes\n\n"
              + "var score = 10;\n\n"
              + "score;\n"
              + "score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        List<CompiledEvaluationResult> results =
                module.evaluateAllResults();

        assertEquals(SephirahType.NUMBER, results.get(0).getType());
        assertEquals(SephirahType.BOOLEAN, results.get(1).getType());
    }
}