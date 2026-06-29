# Sephirah

Sephirah is a small expression-language project built with Xtext. Its near-term purpose is to provide a typed, validated expression layer for larger rule-governed systems, while remaining useful on its own as a readable formula language.

This repository focuses on the Sephirah layer only. Briah and Bat Kol are larger design targets, but Sephirah is the concrete working base: expressions, definitions, variable assignments, validation, and editor/tooling feedback.

## Current status

- Xtext-based language project using the `com.fearlesstyrant.sephirah` package family.
- Eclipse editor/plugin support for `.seph` files.
- Parser and validator work for definitions, variable assignments, and evaluation statements.
- Grammar direction supports mixed ordering among definitions, variable assignments, and evaluation statements so modules can be treated declaratively rather than as strictly sequential scripts.
- Current UX direction favors non-mutating informational feedback/markers for expression results rather than auto-editing source files.

## Why this matters

Many real systems encode rules, formulas, and conditional logic inside ordinary application code. That can make rules difficult to read, validate, explain, test, and modify. Sephirah is an early step toward a stack where rule expressions become explicit language artifacts instead of hidden implementation details.

## Repository layout

```text
com.fearlesstyrant.sephirah/          Core grammar/runtime project
com.fearlesstyrant.sephirah.ide/      IDE integration
com.fearlesstyrant.sephirah.ui/       Eclipse UI integration
com.fearlesstyrant.sephirah.tests/    Language/runtime tests
com.fearlesstyrant.sephirah.ui.tests/ UI tests
com.fearlesstyrant.sephirah.feature/  Eclipse feature project
com.fearlesstyrant.sephirah.updatesite/ Eclipse update site project
examples/                        Small `.seph` examples
tools/                           Repo/demo helper scripts
```

## Demo examples

The `examples/` folder is meant to show the language at a glance:

- `01-basic-expressions.seph`
- `02-definitions-and-variables.seph`
- `03-declarative-ordering.seph`

A future-facing boolean example is kept under `examples/future/` until boolean return values are fully supported and documented.

## Demo tooling

This launch kit includes three lightweight tools:

1. `repo_health_check.ps1` — checks that the repo root is clean and not accidentally pointed at an Eclipse workspace root.
2. `tools/build_showcase.py` — generates a Markdown showcase from the example `.seph` files.
3. `tools/publish_sephirah.ps1` — publishes the existing local repository to GitHub using GitHub CLI.

## Running the showcase generator

From the repository root:

```powershell
python tools/build_showcase.py
```

This writes:

```text
docs/showcase.md
```

## Publishing

Install and authenticate GitHub CLI first, then run from the Sephirah repo root:

```powershell
.\tools\repo_health_check.ps1
.\tools\publish_sephirah.ps1 -Visibility public
```

Use `-Visibility private` if you want to review the published repo before making it public.

## Portfolio framing

Suggested one-line description:

> Sephirah is an Xtext-based expression language for readable, validated formulas and rule-system computations.

Suggested resume bullet:

> Built an Xtext-based domain-specific language with parser, validation, Eclipse editor integration, example programs, and a GitHub-ready demonstration workflow.

## Roadmap

- Stabilize the expression type system.
- Add/finish boolean values as first-class evaluable return values.
- Add CLI validation: `sephirah validate examples/*.seph`.
- Add non-mutating preview/diagnostic output for expression results.
- Add richer examples for game/stat formulas, constraints, and rule-system expressions.
- Add CI once the local Maven/Tycho build is confirmed from a clean clone.
