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
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javaee.solutions.pgn.base.IGameFilter;
import javaee.solutions.pgn.base.filter.RemoveFisherChessFilter;
import javaee.solutions.pgn.lichess.LichessConstants;
import javaee.solutions.pgn.lichess.LichessDataCollector;
import javaee.solutions.pgn.playchess.PlaychessConstants;
import javaee.solutions.pgn.playchess.PlaychessDataCollector;

public class ConverterTest {

    @Test
    public void doIt() throws IOException {
        parsePlaychess();
        parseLichess();
    }

    private void parsePlaychess() throws IOException {
        final IGameFilter gameFilter = new RemoveFisherChessFilter();

        final List<String> files = new ArrayList<>();
        files.add(PlaychessConstants.PGN1_EXTERNAL);
        files.add(PlaychessConstants.PGN2_EXTERNAL);

        for (final String file : files) {
            final PlaychessDataCollector collector = new PlaychessDataCollector(gameFilter);
            javaee.solutions.pgn.playchess.util.ParserUtil.parse(file, collector);

            // TODO: implement me.
            System.out.println(collector.getGames().size());
        }
    }

    private void parseLichess() throws IOException {
        final IGameFilter gameFilter = new RemoveFisherChessFilter();

        final List<String> files = new ArrayList<>();
        files.add(LichessConstants.PGN1_EXTERNAL);

        for (final String file : files) {
            final LichessDataCollector collector = new LichessDataCollector(gameFilter);
            javaee.solutions.pgn.lichess.util.ParserUtil.parse(file, collector);

            // TODO: implement me.
            System.out.println(collector.getGames().size());
        }
    }

}