# CPS 710 – VNM Interpreter

## Overview

This project is developed for CPS 710 (Introduction to Compiler Design) at Toronto Metropolitan University. Over four parts, I built a complete interpreter for **VNM (Virtual Numeric Machine)**, a domain-specific language. The project progressively constructs each layer of a compiler pipeline — from scanning raw source text all the way to executing VNM instructions.

---

## What is VNM?

VNM is a domain-specific language designed for this course. The interpreter reads VNM source code, processes it through a full compiler pipeline, and executes the resulting instructions in a virtual runtime environment. VNM supports:

- **Variable storage** – declaring and assigning values
- **Arithmetic logic** – numeric expressions and operations
- **Control flow** – jumps and branches (e.g. loops and conditionals)

---

## Project Parts

| Part | Component          | Description |
|------|--------------------|-------------|
| 1    | **Scanner**        | Lexical analysis — tokenizes VNM source code using regular expressions |
| 2    | **Parser**         | Syntax analysis — parses tokens using a JavaCC grammar (`VNM.jj`) |
| 3    | **AST Generation** | Builds an Abstract Syntax Tree from the parse tree using JJTree (`VNM.jjt`) |
| 4    | **Interpreter**    | Walks the AST and executes VNM instructions in a runtime environment |

---

## Part 3 – AST Generation

Part 3 focuses on transforming the parser output into a structured Abstract Syntax Tree (AST) using **JJTree**, the tree-building extension of JavaCC. The `VNM.jjt` file defines both the grammar and the tree-node annotations that control how the AST is constructed.

### Key Concepts
- **JJTree** automatically generates AST node classes from annotated grammar productions
- The AST serves as the intermediate representation (IR) passed to the interpreter in Part 4
- All changes are made exclusively in `VNM.jjt`

---
