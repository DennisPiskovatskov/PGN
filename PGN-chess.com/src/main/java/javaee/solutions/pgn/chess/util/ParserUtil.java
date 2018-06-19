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

import java.io.IOException;
import java.nio.charset.Charset;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javaee.solutions.pgn.chess.generated.PGNLexer;
import javaee.solutions.pgn.chess.generated.PGNListener;
import javaee.solutions.pgn.chess.generated.PGNParser;

/**
 * Utility to work with ANTLR tree.
 */
public final class ParserUtil {

    /**
     * Default constructor.
     */
    private ParserUtil() {
        // no instance of this class allowed.
    }

    /**
     * Parse PGN.
     *
     * @param fileName
     *            PGN file name to parse
     * @param listener
     *            ANTLR PGN listener
     * @throws IOException
     *             I/O
     */
    public static void parse(final String fileName, final PGNListener listener) throws IOException {
        // Build lexer and parser
        final CharStream charStream = CharStreams.fromFileName(fileName, Charset.forName("UTF-8"));
        final PGNLexer lexer = new PGNLexer(charStream);
        final PGNParser parser = new PGNParser(new CommonTokenStream(lexer));

        // Tree walker
        final ParseTreeWalker walker = new ParseTreeWalker();
        final ParseTree tree = parser.parse();
        walker.walk(listener, tree);
    }

}
