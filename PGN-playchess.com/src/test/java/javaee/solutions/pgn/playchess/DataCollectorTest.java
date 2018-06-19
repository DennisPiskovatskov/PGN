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
package javaee.solutions.pgn.playchess;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javaee.solutions.pgn.base.entity.PGNGame;
import javaee.solutions.pgn.base.enumeration.EResult;
import javaee.solutions.pgn.playchess.util.ParserUtil;

/**
 * Test for <code>DataCollector</code>.
 */
public class DataCollectorTest {

    @Test
    public void testParse() throws Exception {
        final DataCollector collector = new DataCollector();
        ParserUtil.parse(Constants.PGN1, collector);

        final List<PGNGame> pgnGames = collector.getGames();
        Assertions.assertEquals(1, pgnGames.size());
        Assertions.assertEquals(13, pgnGames.get(0).getTags().size());
        Assertions.assertEquals(68, pgnGames.get(0).getMoves().size());
        Assertions.assertEquals(EResult.WHITE_WINS, pgnGames.get(0).getResult());
    }

}
