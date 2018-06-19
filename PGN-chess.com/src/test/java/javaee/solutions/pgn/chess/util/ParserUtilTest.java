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
package javaee.solutions.pgn.chess.util;

import org.junit.jupiter.api.Test;

import javaee.solutions.pgn.chess.ChessConstants;
import javaee.solutions.pgn.chess.generated.PGNBaseListener;
import javaee.solutions.pgn.chess.generated.PGNParser;

/**
 * Test for <code>ParserUtil</code>.
 */
public class ParserUtilTest {

    @Test
    public void testParse() throws Exception {
        final String[] fileNames = { ChessConstants.TEST1, ChessConstants.TEST2, ChessConstants.TEST3,
                ChessConstants.TEST4 };
        for (final String fileName : fileNames) {
            ParserUtil.parse(fileName, new ExampleListener());
        }
        System.out.println("\nEnjoy!");
    }

    /**
     * Example listener.
     */
    private static class ExampleListener extends PGNBaseListener {

        @Override
        public void enterGame(final PGNParser.GameContext ctx) {
            System.out.println("game: " + ctx.getText());
        }

        @Override
        public void enterTag_section(final PGNParser.Tag_sectionContext ctx) {
            System.out.println("tag_section: " + ctx.getText());
        }

        @Override
        public void enterTag_pair(final PGNParser.Tag_pairContext ctx) {
            System.out.println("tag_pair: " + ctx.getText());
        }

        @Override
        public void enterTag(final PGNParser.TagContext ctx) {
            System.out.println("tag: " + ctx.getText());
        }

        @Override
        public void enterTag_name(final PGNParser.Tag_nameContext ctx) {
            System.out.println("tag_name: " + ctx.getText());
        }

        @Override
        public void enterTag_value(final PGNParser.Tag_valueContext ctx) {
            System.out.println("tag_value: " + ctx.getText());
        }

        @Override
        public void enterMovetext_section(final PGNParser.Movetext_sectionContext ctx) {
            System.out.println("movetext_section: " + ctx.getText());
        }

        @Override
        public void enterMove_number(final PGNParser.Move_numberContext ctx) {
            System.out.println("move_number: " + ctx.getText());
        }

        @Override
        public void enterMove(final PGNParser.MoveContext ctx) {
            System.out.println("move: " + ctx.getText());
        }

        @Override
        public void enterTime(final PGNParser.TimeContext ctx) {
            System.out.println("time: " + ctx.getText());
        }

        @Override
        public void enterGame_termination(final PGNParser.Game_terminationContext ctx) {
            System.out.println("game_termination: " + ctx.getText());
        }
    }

}
