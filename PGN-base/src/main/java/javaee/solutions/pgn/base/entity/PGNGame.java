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
package javaee.solutions.pgn.base.entity;

import java.util.ArrayList;
import java.util.List;

import javaee.solutions.pgn.base.enumeration.EResult;

/**
 * PGN game entity. For more information see <code>PGN.g4</code>.
 */
public class PGNGame {

    private final List<Tag> tags = new ArrayList<>();
    private final List<Move> moves = new ArrayList<>();
    private EResult result;

    public List<Tag> getTags() {
        return tags;
    }

    /**
     * Add tag.
     *
     * @param tag
     */
    public void addTag(final Tag tag) {
        tags.add(tag);
    }

    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Add move.
     *
     * @param move
     */
    public void addMove(final Move move) {
        moves.add(move);
    }

    public EResult getResult() {
        return result;
    }

    public void setResult(final EResult result) {
        this.result = result;
    }

}