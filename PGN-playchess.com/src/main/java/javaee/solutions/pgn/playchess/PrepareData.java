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

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

import javaee.solutions.pgn.base.IPrepareData;

public class PrepareData implements IPrepareData {

    public static enum ESection {
        NONE, METADATA, GAME, SECTION_BETWEEN_GAMES
    }

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public void cleanup(final File input, final File output) throws IOException {
        FileUtils.deleteQuietly(output);

        final StringBuilder result = new StringBuilder();
        StringBuilder game = new StringBuilder();
        ESection previewSection = ESection.NONE;
        for (String line : FileUtils.readLines(input, UTF8)) {
            line = line.replace("\uFEFF", ""); // NOTE: remove UnicodeBOM
            final ESection actualSection = findSection(previewSection, line);
            switch (actualSection) {
            case METADATA:
                result.append(line).append(LINE_SEPARATOR);
                break;
            case GAME:
                game.append(line).append(" ");
                break;
            case SECTION_BETWEEN_GAMES:
                result.append(cleanupGame(game.toString())).append(LINE_SEPARATOR).append(LINE_SEPARATOR);
                game = new StringBuilder();
                break;
            default:
            case NONE:
                result.append(LINE_SEPARATOR);
                break;
            }

            previewSection = actualSection;
        }

        FileUtils.write(output, result, UTF8, true);
    }

    private ESection findSection(final ESection previewSection, final String line) {
        if (line.startsWith("[") && !line.startsWith("[%")) {
            return ESection.METADATA;
        } else if ("".equals(line)) {
            if (previewSection == ESection.GAME) {
                return ESection.SECTION_BETWEEN_GAMES;
            } else {
                return ESection.NONE;
            }
        } else {
            return ESection.GAME;
        }
    }

    private String cleanupGame(final String game) {
        final String result = game.replaceAll("\\].*?}", "]}");
        return result.replaceAll("  ", " ").replaceAll("\\{ \\[", "{[");
    }

}