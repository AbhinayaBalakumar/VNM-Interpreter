# CPS 710 – VNM Interpreter: Part 2 – Parser

## Overview

Part 2 builds on the scanner from Part 1 to implement a **parser** for the VNM (Virtual Numeric Machine) language. This is done as part of CPS 710 (Compilers and Interpreters) at Toronto Metropolitan University. The parser takes the stream of tokens produced by the scanner and verifies that they follow the grammatical rules of VNM, structured according to a provided BNF grammar.

All work is done in `VNM.jj` using **JavaCC**.

---

## What is a Parser?

A parser performs **syntax analysis** — the second phase of the compiler pipeline. It reads tokens from the scanner and checks whether they form valid sentences according to the language's grammar. The grammar for VNM is provided in `grammarVNM.txt` in BNF form, which is then converted into JavaCC parser functions.

The parser is built in two stages:
1. **Stage 1 – Grammar manipulation**: Edit the BNF grammar in `grammarVNM.txt` to resolve ambiguities and ensure the grammar is suitable for LL(k) parsing.
2. **Stage 2 – JavaCC implementation**: Convert the BNF grammar into recursive descent parser functions inside `VNM.jj`.

---

## Project Pipeline

| Part | Component       | Description |
|------|-----------------|-------------|
| 1    | Scanner         | Tokenizes VNM source code |
| **2**    | **Parser**      | Validates token structure against the grammar ← *You are here* |
| 3    | AST Generation  | Builds an Abstract Syntax Tree using JJTree |
| 4    | Interpreter     | Evaluates the AST and executes the program |

---

## Key Files

| File              | Description |
|-------------------|-------------|
| `VNM.jj`          | Main JavaCC grammar file — scanner + parser |
| `grammarVNM.txt`  | Full BNF grammar for the VNM language |
| `bnftojj.sed`     | Sed script to help convert BNF grammar to JavaCC format |
| `p1sol/`          | Model solution for Part 1 (use if Part 1 is incomplete) |
| `tests/`          | Test cases and expected output |
| `runtests`, `t`   | Test runner scripts |
| `Makefile`        | Compiles the project |

---
