# CPS 710 – VNM Interpreter: Part 4 – Interpreter

## Overview

Part 4 is the final stage of the CPS 710 (Compilers and Interpreters) project at Toronto Metropolitan University. In this part, you implement the **interpreter** for the VNM (Virtual Numeric Machine) language. The interpreter walks the Abstract Syntax Tree (AST) produced in Part 3 and executes VNM programs by evaluating each node according to the language's semantics.

This part uses the **Visitor design pattern** via a generated evaluator class (`VNMEval.java`) that defines how each type of AST node should be evaluated at runtime.

---

## What Does the Interpreter Do?

The interpreter is the final phase of the compiler pipeline. Rather than generating machine code, it directly **executes** the VNM program by traversing the AST and computing results. The runtime environment supports:

- **Variable storage** – a symbol table (store) that maps variable names to their current values
- **Arithmetic operations** – evaluating expressions involving `+`, `-`, `*`, `/`, `%`
- **Control flow** – executing `if/else` conditionals and `while` loops by following branches in the AST
- **Boolean logic** – evaluating conditions using `and`, `or`, `not`, and comparison operators
- **Assignment** – updating variable values in the store
- **Output** – printing results of expressions

---

## Project Pipeline

| Part | Component         | Description |
|------|-------------------|-------------|
| 1    | Scanner           | Tokenizes VNM source code |
| 2    | Parser            | Validates token structure against the grammar |
| 3    | AST Generation    | Builds the AST using JJTree |
| **4**    | **Interpreter**   | Walks the AST and executes the program ← *You are here* |

---

## Key Concepts

- **Visitor pattern**: JJTree generates a `VNMDefaultVisitor.java` stub with one `visit()` method per AST node type. You copy this to `VNMEval.java` and implement each method to define how that node should be evaluated.
- **Store (symbol table)**: A `Map<String, Integer>` (or similar) that tracks the current values of all variables during execution.
- **Tree traversal**: The interpreter recursively visits child nodes to evaluate subexpressions before computing the result of a parent node.

---
