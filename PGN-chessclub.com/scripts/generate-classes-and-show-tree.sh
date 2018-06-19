#!/bin/bash

target="../target"

./antlr4-tester.sh PGN.g4 ../src/test/resources/chessclub.com/icc_Zayats72-25percent.pgn parse > $target/tree.antlr4