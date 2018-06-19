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
package javaee.solutions.pgn.chess;

import javaee.solutions.pgn.base.BaseConstants;

/**
 * Constants for tests.
 */
public final class ChessConstants extends BaseConstants {

    // chess.com
    public static final String PGN1 = RESOURCES + "chess.com/1.pgn";
    public static final String PGN2 = RESOURCES + "chess.com/chess_com_games_2018-06-15_tribrack.pgn";
    public static final String PGN3 = RESOURCES + "chess.com/chess_com_games_2018-06-07_tribrack.pgn";
    public static final String PGN4 = RESOURCES + "chess.com/chess_com_games_2018-06-15_Hikaru.pgn";
    public static final String PGN4_EXTERNAL = "../PGN-chess.com/" + PGN4;

    private ChessConstants() {
        // no instance of this class allowed.
    }

}
