# CLI Validator Design Sketch

Target module:

```text
com.fearlesstyrant.sephirah.cli
```

Target commands:

```powershell
sephirah validate examples/03-declarative-ordering.seph
sephirah validate examples/*.seph
sephirah showcase examples/*.seph
```

## Target behavior

- Exit code `0`: all files parse and validate.
- Exit code `1`: one or more files contain parse/validation errors.
- Output should be stable, plain text, and easy to paste into README screenshots.

## Target output

```text
OK examples/01-basic-expressions.seph
OK examples/02-definitions-and-variables.seph
OK examples/03-declarative-ordering.seph
```

For errors:

```text
ERROR examples/bad.seph:3:8 Unknown symbol 'strenght_mod'. Did you mean 'strength_mod'?
```

## Implementation notes

Use the generated Xtext standalone setup, load each file into an EMF `ResourceSet`, then run the Xtext validator. Keep this as a separate module so the core language stays clean.

Pseudo-flow:

```text
main(args)
  parse command
  for each file
    load resource
    collect parse diagnostics
    run validator
    print OK or ERROR lines
  exit with aggregate status
```

## Why this is the next best demo

The Eclipse plugin proves editor integration. The CLI proves that the language can be used in build pipelines, scripts, and non-Eclipse tooling. That makes Sephirah easier for employers to understand as engineering work rather than just IDE experimentation.
