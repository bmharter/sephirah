# Sephirah Showcase

This page is generated from the example `.seph` files in `examples/`.

Sephirah is currently demonstrated through readable source examples. The next major demo step is a CLI validator that can parse and validate these same files from the command line.


## Basic Expressions

`examples/01-basic-expressions.seph`

```sephirah
5 + 7
12 * 3
(10 + 2) / 3
```

## Definitions And Variables

`examples/02-definitions-and-variables.seph`

```sephirah
def proficiency(level) = (level + 7) / 4

def attack_bonus(level, strength_mod) = proficiency(level) + strength_mod

level = 5
strength_mod = 3

attack_bonus(level, strength_mod)
```

## Declarative Ordering

`examples/03-declarative-ordering.seph`

```sephirah
attack_bonus(level, strength_mod)

level = 5

strength_mod = 3

def attack_bonus(level, strength_mod) = proficiency(level) + strength_mod

def proficiency(level) = (level + 7) / 4
```

## Future Syntax Targets

These examples are intentionally disabled until the implementation catches up.


### boolean-return-target.seph.disabled

`examples/future/boolean-return-target.seph.disabled`

```sephirah
def is_veteran(level) = level >= 5

level = 7

is_veteran(level)
```
