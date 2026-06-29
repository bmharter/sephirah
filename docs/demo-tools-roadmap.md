# Sephirah Demo Tools Roadmap

The goal is to make Sephirah understandable to employers and collaborators without requiring them to know Xtext first.

## Tool 1 — Example Showcase Generator

Status: included in this kit.

Purpose: generate `docs/showcase.md` from the example `.seph` files.

Why it helps: a visitor can see the language syntax and intended use immediately.

## Tool 2 — Repo Health Check

Status: included in this kit.

Purpose: prevent accidental publication of Eclipse workspace metadata or generated build output.

Why it helps: keeps the repository professional and avoids the earlier workspace-root Git problem.

## Tool 3 — CLI Validator

Status: next implementation target.

Target command:

```powershell
sephirah validate examples/03-declarative-ordering.seph
```

Target output:

```text
OK examples/03-declarative-ordering.seph
```

Or, for invalid files:

```text
ERROR examples/bad.seph:4:12 Unknown symbol 'strenght_mod'. Did you mean 'strength_mod'?
```

Implementation path:

1. Add a small CLI module, likely `com.fearlesstyrant.sephirah.cli`.
2. Use the generated Xtext standalone setup.
3. Load `.seph` files into an EMF resource set.
4. Run validation.
5. Print diagnostics in a stable text format.
6. Add tests using known-good and known-bad example files.

## Tool 4 — Non-mutating Result Preview

Status: design target.

Purpose: show expression results through markers, hover text, side panel output, or CLI preview without inserting generated comments into source files.

Important safety rule: preview should avoid unsafe runtime side effects such as dice rolls unless explicitly run in preview-safe mode.

## Tool 5 — Web/GitHub Pages Demo

Status: later.

Purpose: provide a static portfolio page explaining the language, current features, screenshots, examples, and roadmap.

Do this after the CLI validator exists, because the strongest demo is an example file plus validation output.
