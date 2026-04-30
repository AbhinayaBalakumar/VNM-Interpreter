# CPS 710 – VNM Interpreter: Part 3 – AST Generation

## Overview

Part 3 extends the parser from Part 2 to automatically construct an **Abstract Syntax Tree (AST)** from the parsed VNM source code. This is part of the CPS 710 (Compilers and Interpreters) project at Toronto Metropolitan University. The AST serves as the structured intermediate representation that the interpreter in Part 4 will walk and evaluate.

This part introduces **JJTree**, a preprocessor for JavaCC that generates AST node classes automatically. All work is done in `VNM.jjt` (the JJTree version of the grammar file).

---

## What is an AST?

An **Abstract Syntax Tree** is a tree representation of the structure of source code. Unlike a raw parse tree, the AST strips away unnecessary syntax details and keeps only the semantically meaningful structure of the program. Each node in the tree represents a construct in the VNM language — such as an assignment, arithmetic operation, or control flow statement.

JJTree generates a separate AST node class for each type of grammar production, allowing the interpreter to traverse and evaluate the tree node by node.

---

## Project Pipeline

| Part | Component         | Description |
|------|-------------------|-------------|
| 1    | Scanner           | Tokenizes VNM source code |
| 2    | Parser            | Validates token structure against the grammar |
| **3**    | **AST Generation**| Builds the AST using JJTree ← *You are here* |
| 4    | Interpreter       | Evaluates the AST and executes the program |

---

## Key Concepts

- **JJTree** is a JavaCC preprocessor — it processes `VNM.jjt` and generates `VNM.jj`, which JavaCC then compiles
- JJTree generates one AST node class per grammar production (e.g. `ASTAssignment`, `ASTAdd`, `ASTWhile`)
- Node annotations in the `.jjt` file control how the tree is shaped
- The AST is the input to the interpreter in Part 4

---
