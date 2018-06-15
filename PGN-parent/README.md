# ANTLR PGN Parser for http://chess.com, http://playchess.com, http://chessclub.com

A Portable Game Notation (PGN) ANTLR 4 grammar and parser.

The grammar can be found in **/PGN.g4.

# Get started

### 0. Clone this repository

```bash
git clone https://github.com/DennisPiskovatskov/PGN.git
```

### 1. Generate Eclipse configuration

```bash
cd PGN-parent
mvn eclipse:clean eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true
```

