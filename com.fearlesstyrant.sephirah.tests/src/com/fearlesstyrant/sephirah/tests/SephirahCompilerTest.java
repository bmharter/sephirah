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
    
    @Test
    public void compiledModuleCanReturnCompiledVariableDescriptor() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileVariableDescriptor\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledVariable variable = module.getVariable("eligible");

        assertEquals("eligible", variable.getName());
        assertEquals(SephirahType.BOOLEAN, variable.getType());
    }
    
    @Test
    public void compiledModuleCanReturnAllCompiledVariableDescriptors() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileAllVariableDescriptors\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        List<CompiledVariable> variables = module.getVariables();

        assertEquals(2, variables.size());
    }
    
    @Test
    public void compiledModuleCanReturnCompiledFunctionDescriptor() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileFunctionDescriptor\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledFunction function = module.getFunction("add");

        assertEquals("add", function.getName());
        assertEquals(true, function.getSignature().accepts(2));
        assertEquals(false, function.getSignature().accepts(1));
    }
    
    @Test
    public void compiledModuleCanReturnBuiltinFunctionDescriptor() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileBuiltinFunctionDescriptor\n\n"
              + "abs(-5);\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledFunction function = module.getFunction("abs");

        assertEquals("abs", function.getName());
        assertEquals(SephirahType.NUMBER, function.getSignature().getReturnType().get());
        assertEquals(SephirahType.NUMBER, function.getSignature().getParameterType(0).get());
    }
    
    @Test
    public void compiledModuleCanReturnAllCompiledFunctionDescriptors() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileAllFunctionDescriptors\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        List<CompiledFunction> functions = module.getFunctions();

        assertEquals(true, functions.stream()
                .anyMatch(function -> function.getName().equals("add")));

        assertEquals(true, functions.stream()
                .anyMatch(function -> function.getName().equals("abs")));
    }
    
    @Test
    public void compiledModuleCanReturnSummary() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileModuleSummary\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n\n"
              + "def add(a, b) = a + b;\n\n"
              + "score;\n"
              + "eligible;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledModuleSummary summary = module.getSummary();

        assertEquals("compileModuleSummary", summary.getName());
        assertEquals(2, summary.getVariables().size());
        assertEquals(2, summary.getEvaluationCount());

        assertEquals(true, summary.getVariables().stream()
                .anyMatch(variable -> variable.getName().equals("score")));

        assertEquals(true, summary.getVariables().stream()
                .anyMatch(variable -> variable.getName().equals("eligible")));

        assertEquals(true, summary.getFunctions().stream()
                .anyMatch(function -> function.getName().equals("add")));

        assertEquals(true, summary.getFunctions().stream()
                .anyMatch(function -> function.getName().equals("abs")));
    }
    
    @Test
    public void compiledModuleDistinguishesDefinedFunctionsFromBuiltins() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileDefinedFunctions\n\n"
              + "def add(a, b) = a + b;\n"
              + "def eligible(score) = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        assertEquals(true, module.getDefinedFunctionNames().contains("add"));
        assertEquals(true, module.getDefinedFunctionNames().contains("eligible"));
        assertEquals(false, module.getDefinedFunctionNames().contains("abs"));

        assertEquals(true, module.hasFunction("abs"));
    }
    
    @Test
    public void compiledModuleSummaryDistinguishesDefinedFunctionsFromBuiltins() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileSummaryDefinedFunctions\n\n"
              + "def add(a, b) = a + b;\n"
              + "def eligible(score) = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledModuleSummary summary = module.getSummary();

        assertEquals(true, summary.getDefinedFunctions().stream()
                .anyMatch(function -> function.getName().equals("add")));

        assertEquals(true, summary.getDefinedFunctions().stream()
                .anyMatch(function -> function.getName().equals("eligible")));

        assertEquals(false, summary.getDefinedFunctions().stream()
                .anyMatch(function -> function.getName().equals("abs")));

        assertEquals(true, summary.getFunctions().stream()
                .anyMatch(function -> function.getName().equals("abs")));
    }
    
    @Test
    public void compiledModuleSummaryIncludesDefinedVariables() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileSummaryDefinedVariables\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledModuleSummary summary = module.getSummary();

        assertEquals(2, summary.getDefinedVariables().size());

        assertEquals(true, summary.getDefinedVariables().stream()
                .anyMatch(variable -> variable.getName().equals("score")));

        assertEquals(true, summary.getDefinedVariables().stream()
                .anyMatch(variable -> variable.getName().equals("eligible")));
    }
    
    @Test
    public void compiledModuleExportsOnlyDefinedSymbols() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileExports\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n\n"
              + "def add(a, b) = a + b;\n\n"
              + "score;\n"
              + "abs(-5);\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledModuleExports exports = module.getExports();

        assertEquals(true, exports.getVariables().stream()
                .anyMatch(variable -> variable.getName().equals("score")));

        assertEquals(true, exports.getVariables().stream()
                .anyMatch(variable -> variable.getName().equals("eligible")));

        assertEquals(true, exports.getFunctions().stream()
                .anyMatch(function -> function.getName().equals("add")));

        assertEquals(false, exports.getFunctions().stream()
                .anyMatch(function -> function.getName().equals("abs")));
    }
    
    @Test
    public void compiledModuleExportsExposeSymbolNames() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileExportNames\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledModuleExports exports = module.getExports();

        assertEquals(true, exports.getVariableNames().contains("score"));
        assertEquals(true, exports.getVariableNames().contains("eligible"));

        assertEquals(true, exports.getFunctionNames().contains("add"));
        assertEquals(false, exports.getFunctionNames().contains("abs"));
    }
    
    @Test
    public void compiledModuleExportsCanLookupVariables() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileExportVariableLookup\n\n"
              + "var score = 10;\n"
              + "var eligible = score >= 10;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledModuleExports exports = module.getExports();

        assertEquals(true, exports.hasVariable("score"));
        assertEquals(false, exports.hasVariable("missing"));

        CompiledVariable variable = exports.getVariable("eligible");

        assertEquals("eligible", variable.getName());
        assertEquals(SephirahType.BOOLEAN, variable.getType());
    }
    
    @Test
    public void compiledModuleExportsCanLookupFunctions() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileExportFunctionLookup\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledSephirahModule module =
                new SephirahCompiler().compile(model);

        CompiledModuleExports exports = module.getExports();

        assertEquals(true, exports.hasFunction("add"));
        assertEquals(false, exports.hasFunction("abs"));

        CompiledFunction function = exports.getFunction("add");

        assertEquals("add", function.getName());
        assertEquals(true, function.getSignature().accepts(2));
    }
    
    @Test
    public void compiledModuleExportsThrowForMissingVariableLookup() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileMissingExportVariableLookup\n\n"
              + "var score = 10;\n");

        CompiledModuleExports exports =
                new SephirahCompiler().compile(model).getExports();

        try {
            exports.getVariable("missing");
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Unknown exported variable: missing",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for missing exported variable.");
    }
    
    @Test
    public void compiledModuleExportsThrowForMissingFunctionLookup() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc compileMissingExportFunctionLookup\n\n"
              + "def add(a, b) = a + b;\n");

        CompiledModuleExports exports =
                new SephirahCompiler().compile(model).getExports();

        try {
            exports.getFunction("missing");
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Unknown exported function: missing",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for missing exported function.");
    }
    
    @Test
    public void compilerCanCompileMultipleModulesIntoModuleSet() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "def double(value) = value * 2;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "var score = 10;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        assertEquals(2, modules.size());

        assertEquals(true, modules.hasModule("math_helpers"));
        assertEquals(true, modules.hasModule("game_rules"));
        assertEquals(false, modules.hasModule("missing"));

        assertEquals(true, modules.getModule("math_helpers").hasFunction("double"));
        assertEquals(true, modules.getModule("game_rules").hasVariable("score"));
    }
    
    @Test
    public void compiledModuleSetThrowsForMissingModule() throws Exception {
        FormulaModel model = parseHelper.parse(
                "SephirahDoc only_module\n\n"
              + "var score = 10;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(model));

        try {
            modules.getModule("missing");
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Unknown module: missing",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for missing module.");
    }
    
    @Test
    public void compiledModuleRecordsImports() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "def double(value) = value * 2;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers;\n\n"
              + "var score = 10;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        CompiledSephirahModule gameRules =
                modules.getModule("game_rules");

        assertEquals(1, gameRules.getImports().size());
        assertEquals(true, gameRules.importsModule("math_helpers"));
        assertEquals("math_helpers", gameRules.getImports().get(0).getLocalName());
    }
    
    @Test
    public void compiledModuleRecordsAliasedImports() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "def double(value) = value * 2;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers as math;\n\n"
              + "var score = 10;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        CompiledImport imported =
                modules.getModule("game_rules").getImports().get(0);

        assertEquals("math_helpers", imported.getModuleName());
        assertEquals("math", imported.getAlias());
        assertEquals("math", imported.getLocalName());
    }
    
    @Test
    public void compileAllThrowsForUnknownImportedModule() throws Exception {
        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers;\n\n"
              + "var score = 10;\n");

        try {
            new SephirahCompiler().compileAll(List.of(game));
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Module game_rules imports unknown module: math_helpers",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for unknown imported module.");
    }
    
    @Test
    public void compiledModuleCanCallAliasedImportedFunction() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "def double(value) = value * 2;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers as math;\n\n"
              + "var result = math.double(5);\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        CompiledSephirahModule gameRules =
                modules.getModule("game_rules");

        assertEquals(
                new BigDecimal("10"),
                gameRules.evaluateNumberVariable("result"));
    }
    
    @Test
    public void compiledModuleCanCallUnaliasedImportedFunction() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "def double(value) = value * 2;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers;\n\n"
              + "var result = math_helpers.double(5);\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        assertEquals(
                new BigDecimal("10"),
                modules.getModule("game_rules")
                        .evaluateNumberVariable("result"));
    }
    
    @Test
    public void importedFunctionsAreCallableButNotExported() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "def double(value) = value * 2;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers as math;\n\n"
              + "var result = math.double(5);\n");

        CompiledSephirahModule gameRules =
                new SephirahCompiler()
                        .compileAll(List.of(math, game))
                        .getModule("game_rules");

        assertEquals(true, gameRules.hasFunction("math.double"));
        assertEquals(false, gameRules.getExports().hasFunction("math.double"));
        assertEquals(false, gameRules.getDefinedFunctionNames().contains("math.double"));
    }
    
    @Test
    public void compiledModuleCanUseAliasedImportedVariable() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "var baseScore = 10;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers as math;\n\n"
              + "var result = math.baseScore + 5;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        assertEquals(
                new BigDecimal("15"),
                modules.getModule("game_rules")
                        .evaluateNumberVariable("result"));
    }
    
    @Test
    public void compiledModuleCanUseUnaliasedImportedVariable() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "var baseScore = 10;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers;\n\n"
              + "var result = math_helpers.baseScore + 5;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        assertEquals(
                new BigDecimal("15"),
                modules.getModule("game_rules")
                        .evaluateNumberVariable("result"));
    }
    
    @Test
    public void compiledModuleCanUseImportedBooleanVariable() throws Exception {
        FormulaModel flags = parseHelper.parse(
                "SephirahDoc flags\n\n"
              + "var enabled = true;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import flags;\n\n"
              + "var result = if flags.enabled then 10 else 0;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(flags, game));

        assertEquals(
                new BigDecimal("10"),
                modules.getModule("game_rules")
                        .evaluateNumberVariable("result"));
    }
    
    @Test
    public void compileAllThrowsForDuplicateModuleNames() throws Exception {
        FormulaModel first = parseHelper.parse(
                "SephirahDoc duplicate\n\n"
              + "var score = 10;\n");

        FormulaModel second = parseHelper.parse(
                "SephirahDoc duplicate\n\n"
              + "var score = 20;\n");

        try {
            new SephirahCompiler().compileAll(List.of(first, second));
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Duplicate Sephirah module name: duplicate",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for duplicate module name.");
    }
    
    @Test
    public void compileAllThrowsForDuplicateImportLocalNames() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "var baseScore = 10;\n");

        FormulaModel combat = parseHelper.parse(
                "SephirahDoc combat_math\n\n"
              + "var damage = 5;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers as math;\n"
              + "import combat_math as math;\n\n"
              + "var result = 10;\n");

        try {
            new SephirahCompiler().compileAll(List.of(math, combat, game));
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Module game_rules has duplicate import local name: math",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for duplicate import local name.");
    }
    
    @Test
    public void compileAllThrowsForDuplicateUnaliasedImports() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "var baseScore = 10;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers;\n"
              + "import math_helpers;\n\n"
              + "var result = 10;\n");

        try {
            new SephirahCompiler().compileAll(List.of(math, game));
        } catch (IllegalArgumentException exception) {
            assertEquals(
                    "Module game_rules has duplicate import local name: math_helpers",
                    exception.getMessage());
            return;
        }

        throw new AssertionError("Expected IllegalArgumentException for duplicate unaliased import.");
    }
    
    @Test
    public void compiledModuleCanInferImportedNumericVariableType() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "var baseScore = 10;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers as math;\n\n"
              + "var result = math.baseScore + 5;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(math, game));

        assertEquals(
                SephirahType.NUMBER,
                modules.getModule("game_rules")
                        .getVariableType("result"));
    }
    
    @Test
    public void compiledModuleCanInferImportedBooleanVariableType() throws Exception {
        FormulaModel flags = parseHelper.parse(
                "SephirahDoc flags\n\n"
              + "var enabled = true;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import flags;\n\n"
              + "var enabledCopy = flags.enabled;\n");

        CompiledSephirahModuleSet modules =
                new SephirahCompiler().compileAll(List.of(flags, game));

        assertEquals(
                SephirahType.BOOLEAN,
                modules.getModule("game_rules")
                        .getVariableType("enabledCopy"));
    }
    
    @Test
    public void compiledVariableDescriptorUsesImportedTypeContext() throws Exception {
        FormulaModel math = parseHelper.parse(
                "SephirahDoc math_helpers\n\n"
              + "var baseScore = 10;\n");

        FormulaModel game = parseHelper.parse(
                "SephirahDoc game_rules\n\n"
              + "import math_helpers as math;\n\n"
              + "var result = math.baseScore + 5;\n");

        CompiledVariable variable =
                new SephirahCompiler()
                        .compileAll(List.of(math, game))
                        .getModule("game_rules")
                        .getVariable("result");

        assertEquals("result", variable.getName());
        assertEquals(SephirahType.NUMBER, variable.getType());
    }
}