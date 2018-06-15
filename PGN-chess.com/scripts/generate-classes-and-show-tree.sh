#!/bin/bash

target="../target"

# ./antlr4-tester.sh PGN.g4 ../src/test/resources/chess.com/1.pgn parse > $target/tree.antlr4
# ./antlr4-tester.sh PGN.g4 ../src/test/resources/chess.com/chess_com_games_2018-06-07_tribrack.pgn parse > $target/tree.antlr4
# ./antlr4-tester.sh PGN.g4 ../src/test/resources/chess.com/chess_com_games_2018-06-15_tribrack.pgn parse > $target/tree.antlr4
./antlr4-tester.sh PGN.g4 ../src/test/resources/chess.com/chess_com_games_2018-06-15_Hikaru.pgn parse > $target/tree.antlr4