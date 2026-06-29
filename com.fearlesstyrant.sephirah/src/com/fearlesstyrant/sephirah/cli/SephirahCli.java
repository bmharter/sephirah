package com.fearlesstyrant.sephirah.cli;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.fearlesstyrant.sephirah.SephirahStandaloneSetup;
import com.fearlesstyrant.sephirah.sephirah.FormulaModel;
import com.fearlesstyrant.sephirah.tools.compile.CompiledEvaluationResult;
import com.fearlesstyrant.sephirah.tools.compile.CompiledFunction;
import com.fearlesstyrant.sephirah.tools.compile.CompiledSephirahModule;
import com.fearlesstyrant.sephirah.tools.compile.CompiledVariable;
import com.fearlesstyrant.sephirah.tools.compile.SephirahCompiler;
import com.google.inject.Injector;

public final class SephirahCli {

    public static void main(String[] args) {
        int exitCode = new SephirahCli().run(args);
        System.exit(exitCode);
    }

    private int run(String[] args) {
        if (args.length == 0 || hasHelpFlag(args)) {
            printUsage();
            return 0;
        }

        String command;
        Path file;

        if (args.length == 1) {
            command = "run";
            file = Path.of(args[0]);
        } else {
            command = args[0].toLowerCase(Locale.ROOT);
            file = Path.of(args[1]);
        }

        if (!Files.isRegularFile(file)) {
            System.err.println("File not found: " + file);
            return 2;
        }

        try {
            LoadedSephirahFile loaded = load(file);
            List<Issue> issues = validate(loaded);

            printIssues(loaded.resource(), issues);

            boolean hasErrors = hasErrors(loaded.resource(), issues);

            if ("validate".equals(command)) {
                if (!hasErrors) {
                    System.out.println("Validation passed.");
                }
                return hasErrors ? 1 : 0;
            }

            if (hasErrors) {
                System.err.println("Cannot continue because validation failed.");
                return 1;
            }

            CompiledSephirahModule module =
                    new SephirahCompiler().compile(loaded.model());

            switch (command) {
                case "summary" -> printSummary(module);
                case "run" -> printRun(module);
                default -> {
                    System.err.println("Unknown command: " + command);
                    printUsage();
                    return 2;
                }
            }

            return 0;
        } catch (Exception exception) {
            System.err.println("Sephirah CLI failed: " + exception.getMessage());
            exception.printStackTrace(System.err);
            return 1;
        }
    }

    private static boolean hasHelpFlag(String[] args) {
        for (String arg : args) {
            if ("--help".equals(arg) || "-h".equals(arg)) {
                return true;
            }
        }
        return false;
    }

    private LoadedSephirahFile load(Path file) {
        Injector injector =
                new SephirahStandaloneSetup()
                        .createInjectorAndDoEMFRegistration();

        XtextResourceSet resourceSet =
                injector.getInstance(XtextResourceSet.class);

        URI uri = URI.createFileURI(file.toAbsolutePath().toString());
        Resource resource = resourceSet.getResource(uri, true);

        if (resource.getContents().isEmpty()
                || !(resource.getContents().get(0) instanceof FormulaModel model)) {
            throw new IllegalArgumentException(
                    "File did not load as a Sephirah FormulaModel: " + file);
        }

        IResourceValidator validator =
                injector.getInstance(IResourceValidator.class);

        return new LoadedSephirahFile(resource, model, validator);
    }

    private List<Issue> validate(LoadedSephirahFile loaded) {
        return loaded.validator().validate(
                loaded.resource(),
                CheckMode.ALL,
                CancelIndicator.NullImpl);
    }

    private static boolean hasErrors(Resource resource, List<Issue> issues) {
        if (!resource.getErrors().isEmpty()) {
            return true;
        }

        return issues.stream()
                .anyMatch(issue -> issue.getSeverity() == Severity.ERROR);
    }

    private static void printIssues(Resource resource, List<Issue> issues) {
        boolean printedAny = false;

        for (Diagnostic diagnostic : resource.getErrors()) {
            printedAny = true;
            System.out.printf(
                    "ERROR %s:%d:%d %s%n",
                    resource.getURI(),
                    diagnostic.getLine(),
                    diagnostic.getColumn(),
                    diagnostic.getMessage());
        }

        for (Diagnostic diagnostic : resource.getWarnings()) {
            printedAny = true;
            System.out.printf(
                    "WARNING %s:%d:%d %s%n",
                    resource.getURI(),
                    diagnostic.getLine(),
                    diagnostic.getColumn(),
                    diagnostic.getMessage());
        }

        for (Issue issue : issues) {
            printedAny = true;
            System.out.printf(
                    "%s %s:%s:%s %s%n",
                    issue.getSeverity(),
                    issue.getUriToProblem(),
                    valueOrQuestion(issue.getLineNumber()),
                    valueOrQuestion(issue.getColumn()),
                    issue.getMessage());
        }

        if (!printedAny) {
            System.out.println("No validation issues.");
        }
    }

    private static String valueOrQuestion(Integer value) {
        return value == null ? "?" : value.toString();
    }

    private static void printSummary(CompiledSephirahModule module) {
        System.out.println("Module: " + module.getName());

        System.out.println();
        System.out.println("Defined variables:");
        if (module.getDefinedVariables().isEmpty()) {
            System.out.println("  <none>");
        } else {
            for (CompiledVariable variable : module.getDefinedVariables()) {
                System.out.printf(
                        "  %s : %s%n",
                        variable.getName(),
                        variable.getType());
            }
        }

        System.out.println();
        System.out.println("Defined functions:");
        if (module.getDefinedFunctions().isEmpty()) {
            System.out.println("  <none>");
        } else {
            for (CompiledFunction function : module.getDefinedFunctions()) {
                System.out.printf(
                        "  %s %s%n",
                        function.getName(),
                        function.getSignature());
            }
        }

        System.out.println();
        System.out.println("Evaluation entries: " + module.getEvaluationCount());
    }

    private static void printRun(CompiledSephirahModule module) {
        printSummary(module);

        System.out.println();
        System.out.println("Variable values:");
        if (module.getDefinedVariables().isEmpty()) {
            System.out.println("  <none>");
        } else {
            for (CompiledVariable variable : module.getDefinedVariables()) {
                System.out.printf(
                        "  %s : %s = %s%n",
                        variable.getName(),
                        variable.getType(),
                        module.evaluateVariable(variable.getName()));
            }
        }

        System.out.println();
        System.out.println("Evaluation results:");
        if (module.getEvaluationCount() == 0) {
            System.out.println("  <none>");
        } else {
            for (CompiledEvaluationResult result : module.evaluateAllResults()) {
                System.out.printf(
                        "  [%d] %s = %s%n",
                        result.getIndex(),
                        result.getType(),
                        result.getValue());
            }
        }
    }

    private static void printUsage() {
        System.out.println("""
                Sephirah CLI

                Usage:
                  SephirahCli validate <file.seph>
                  SephirahCli summary  <file.seph>
                  SephirahCli run      <file.seph>

                Default:
                  SephirahCli <file.seph>

                Examples:
                  SephirahCli validate examples/01-basic-expressions.seph
                  SephirahCli run examples/02-definitions-and-variables.seph
                """);
    }

    private record LoadedSephirahFile(
            Resource resource,
            FormulaModel model,
            IResourceValidator validator) {
    }
}
