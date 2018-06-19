#!/bin/bash

target="../target"

./antlr4-tester.sh PGN.g4 ../src/test/resources/chessclub.com/icc_Zayats71.pgn parse > $target/tree.antlr4