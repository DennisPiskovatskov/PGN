# ANTLR PGN Parser for http://chess.com, http://playchess.com, http://chessclub.com, http://lichess.com

A Portable Game Notation (PGN) ANTLR 4 grammar and parser.

The grammar can be found in PGN/PGN-**/scripts/PGN.g4.

# Get started

### 0. Generate Eclipse configuration

```bash
cd PGN-parent
mvn eclipse:clean eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true
```

### 1. Generate ANTLR Lexer and Parser classes

```bash
cd PGN/PGN-**/scripts
./generate-classes-and-show-tree.sh
# the human readable result can be found in each module PGN/PGN-**/target/tree.antlr4
```

