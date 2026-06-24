package com.fearlesstyrant.sephirah.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.fearlesstyrant.sephirah.sephirah.FormulaModel;
import com.fearlesstyrant.sephirah.tools.compile.CompiledSephirahModule;
import com.fearlesstyrant.sephirah.tools.compile.SephirahCompiler;

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
}