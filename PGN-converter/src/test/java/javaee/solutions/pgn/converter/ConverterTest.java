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
 * Project      : A Portable Game Notation (PGN) ANTLR 4 grammar,
 *                parser & Converter to Stockfish
 * Developed by : Dennis Piskovatskov, dennis.piskovatskov@javaee.solutions
 */
package javaee.solutions.pgn.converter;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import javaee.solutions.pgn.base.IGameFilter;
import javaee.solutions.pgn.base.filter.RemoveFisherChessFilter;
import javaee.solutions.pgn.playchess.DataCollector;
import javaee.solutions.pgn.playchess.PlaychessConstants;
import javaee.solutions.pgn.playchess.util.ParserUtil;

public class ConverterTest {

    @Test
    public void doIt() throws IOException {
        final IGameFilter gameFilter = new RemoveFisherChessFilter();
        final DataCollector collector = new DataCollector(gameFilter);
        ParserUtil.parse(PlaychessConstants.PGN1_EXTERNAL, collector);

        System.out.println(collector.getGames().size());
    }

}
