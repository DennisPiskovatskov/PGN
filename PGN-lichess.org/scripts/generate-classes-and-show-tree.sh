#!/bin/bash

target="../target"

./antlr4-tester.sh PGN.g4 ../src/test/resources/lichess.org/lichess.pgn parse > $target/tree.antlr4