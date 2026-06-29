#!/usr/bin/env python3
"""Generate docs/showcase.md from examples/*.seph.

This tool is deliberately simple so it works before Sephirah has a CLI validator.
It gives the repository an immediate portfolio-friendly demo page.
"""

from __future__ import annotations

from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
EXAMPLES = ROOT / "examples"
OUTPUT = ROOT / "docs" / "showcase.md"

INTRO = """# Sephirah Showcase

This page is generated from the example `.seph` files in `examples/`.

Sephirah is currently demonstrated through readable source examples. The next major demo step is a CLI validator that can parse and validate these same files from the command line.

"""


def title_for(path: Path) -> str:
    stem = path.stem
    stem = stem.replace("01-", "").replace("02-", "").replace("03-", "")
    return stem.replace("-", " ").title()


def main() -> int:
    files = sorted(EXAMPLES.glob("*.seph"))
    if not files:
        raise SystemExit("No .seph example files found.")

    sections: list[str] = [INTRO]
    for path in files:
        rel = path.relative_to(ROOT).as_posix()
        source = path.read_text(encoding="utf-8").strip()
        sections.append(f"## {title_for(path)}\n\n`{rel}`\n\n```sephirah\n{source}\n```\n")

    future_files = sorted((EXAMPLES / "future").glob("*.seph.disabled"))
    if future_files:
        sections.append("## Future Syntax Targets\n\nThese examples are intentionally disabled until the implementation catches up.\n\n")
        for path in future_files:
            rel = path.relative_to(ROOT).as_posix()
            source = path.read_text(encoding="utf-8").strip()
            sections.append(f"### {path.name}\n\n`{rel}`\n\n```sephirah\n{source}\n```\n")

    OUTPUT.parent.mkdir(parents=True, exist_ok=True)
    OUTPUT.write_text("\n".join(sections), encoding="utf-8")
    print(f"Wrote {OUTPUT.relative_to(ROOT)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
