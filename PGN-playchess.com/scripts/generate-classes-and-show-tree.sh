#!/bin/bash

target="../target"

./antlr4-tester.sh PGN.g4 ../target/PC_Zayats71-1.pgn parse > $target/tree.antlr4
# ./antlr4-tester.sh PGN.g4 ../target/PC_Zayats71-2.pgn parse > $target/tree.antlr4
