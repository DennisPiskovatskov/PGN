#!/bin/bash

target="../target"

./antlr4-tester.sh PGN.g4 ../target/lichess.pgn parse > $target/tree.antlr4