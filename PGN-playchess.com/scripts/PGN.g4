/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 by Dennis Piskovatskov
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * Project      : A Portable Game Notation (PGN) ANTLR 4 grammar
 *                and parser for {@link http://chess.com}
 * Developed by : Dennis Piskovatskov, dennis.piskovatskov@javaee.solutions
 */
grammar PGN;

/// This rule allows ANTLR 4 to parse grammars using the UTF-8 encoding with a
/// byte order mark. Since this Unicode character doesn't appear as a token
/// anywhere else in the grammar, we can simply skip all instances of it without
/// problem. This rule will not break usage of \uFEFF inside a LEXER_CHAR_SET or
/// STRING_LITERAL.
UnicodeBOM
 : '\uFEFF' -> skip
 ;

/// The entry point of the grammar.
parse
 : game* EOF
 ;

/// .
game
 : tag_section movetext_section BLANK*
 ;

/// .
tag_section
 : tag_pair+
 ;

/// [WhiteElo "1629"]
tag_pair
 : LEFT_BRACKET tag RIGHT_BRACKET BLANK*
 ;

/// WhiteElo "1629"
tag
 : tag_name BLANK tag_value
 ;

/// WhiteElo
tag_name
 : NAME
 ;

/// "1629"
tag_value
 : STRING
 ;
 
/// .
movetext_section
 : element_sequence* game_termination
 ;

/// 1. e4 {[%emt 0:02:59]}
element_sequence
 : move_number BLANK* move_element move_element?
 ;

/// 1.
move_number
 : MOVE_NUMBER
 ;

/// e4 {[%emt 0:00:00]}
 move_element
 : move BLANK? emt? BLANK*
 ;

/// .
move
 : MOVE
 ;

/// .
emt
 : '{' WS? '[%emt' BLANK time ']' WS? '}' BLANK*
 ;

/// .
time
 : TIME
 ;

/// 1-0 | 0-1 | 1/2-1/2
game_termination
 : WHITE_WINS
 | BLACK_WINS
 | DRAWN_GAME
 | ASTERIX
 ;

/// .
MOVE_NUMBER
 : INTEGER PERIOD
 ; 

/// Nce6+ | O-O | O-O-O
MOVE
 : MOVE_PIECE_TO_FIELD [+#]? | 'O-O' | 'O-O-O'
 ;

/// e4 | Nf3 | Nxc6 | Nce6 | exd4 | b1=Q | Ndxe | R8e3 | Rfxd3 | R2xc3 | dxc8=Q+
MOVE_PIECE_TO_FIELD
 : (BOARD_LETTER [x])? BOARD_FIELD ([=] PIECE)? /// e4 | exd4 | dxc8=Q+
 | (PIECE (BOARD_LETTER | BOARD_NUMBER)? [x]? BOARD_FIELD) /// Nf3 | Nxc6 | Rfxd3 R2xc3
 | (PIECE (BOARD_LETTER | BOARD_NUMBER) (([x] BOARD_LETTER) | BOARD_FIELD)) /// Ndxe | Nce6 | R8e3
 | (BOARD_FIELD [=] PIECE) /// b1=Q
 ;

/// R
PIECE
 : [RNBQK]
 ;

/// A1
BOARD_FIELD
 : BOARD_LETTER BOARD_NUMBER
 ;

// 1
BOARD_NUMBER
 : [1-8]
 ;

/// a
BOARD_LETTER
 : [abcdefgh]
 ;
 
/// [0:9] ':' [0-9][0-9] ':' [0-9][0-9]
TIME
 : INTEGER ':' WS? INTEGER ':' WS? INTEGER
 ;

// BlackElo
NAME
 : [A-Z]+ [a-zA-Z]+
 ;

WHITE_WINS
 : '1-0'
 ;

BLACK_WINS
 : '0-1'
 ;

DRAWN_GAME
 : '1/2-1/2'
 ;

ASTERIX
 : '*'
 ;

/// A string token is a sequence of zero or more printing characters delimited by a
/// pair of quote characters (ASCII decimal value 34, hexadecimal value 0x22).  An
/// empty string is represented by two adjacent quotes.  (Note: an apostrophe is
/// not a quote.)  A quote inside a string is represented by the backslash
/// immediately followed by a quote.  A backslash inside a string is represented by
/// two adjacent backslashes.  Strings are commonly used as tag pair values (see
/// below).  Non-printing characters like newline and tab are not permitted inside
/// of strings.  A string token is terminated by its closing quote.  Currently, a
/// string is limited to a maximum of 255 characters of data.
STRING
 : '"' ('\\\\' | '\\"' | ~[\\"])* '"'
 ;

/// ' '
BLANK
 : ' '
 ;

/// Skip all \r and \n -> channel(HIDDEN)
WS
 : [ \r\n]+ -> skip
 ;

/// Digit
INTEGER
 : [0-9]+
 ;

/// .
PERIOD
 : '.'
 ;

/// The left and right bracket characters ("[" and "]") are tokens.  They are used
/// to delimit tag pairs (see below).  Both are self terminating.
LEFT_BRACKET
 : '['
 ;

RIGHT_BRACKET
 : ']'
 ;

 