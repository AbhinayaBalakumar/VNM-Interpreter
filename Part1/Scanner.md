# CPS 710 – VNM Interpreter: Part 1 – Scanner

## Overview

Part 1 is the first step in building a complete interpreter for **VNM (Virtual Numeric Machine)**, a domain-specific language developed for CPS 710 (Compilers and Interpreters) at Toronto Metropolitan University. In this part, you implement the **scanner** (also called a lexer), which is responsible for reading raw VNM source code and breaking it down into a stream of tokens.

The scanner is built using **JavaCC**, a lexer and parser generator for Java. All work is done in a single grammar file: `VNM.jj`.

---

## What is a Scanner?

A scanner performs **lexical analysis** — the first phase of the compiler pipeline. It reads the raw characters of a source file and groups them into meaningful units called **tokens**. For example:

- Keywords like `if`, `while`, `print`
- Identifiers (variable names)
- Integer and numeric literals
- Operators and symbols (`+`, `-`, `=`, `;`)
- Whitespace and comments (typically skipped)

Tokens are defined using **regular expressions** inside the JavaCC grammar file.

---

## Project Pipeline

| Part | Component       | Description |
|------|-----------------|-------------|
| **1**    | **Scanner**     | Tokenizes VNM source code ← *You are here* |
| 2    | Parser          | Parses tokens into a syntax structure |
| 3    | AST Generation  | Builds an Abstract Syntax Tree using JJTree |
| 4    | Interpreter     | Evaluates the AST and executes the program |

---
