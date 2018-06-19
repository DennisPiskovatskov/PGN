#!/bin/bash

target="../target"

./antlr4-tester.sh PGN.g4 ../target/PC_Zayats71.pgn parse > $target/tree.antlr4