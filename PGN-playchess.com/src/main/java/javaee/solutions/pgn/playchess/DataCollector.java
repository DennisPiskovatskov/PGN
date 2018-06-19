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

import java.util.ArrayList;
import java.util.List;

import javaee.solutions.pgn.base.IDataCollector;
import javaee.solutions.pgn.base.entity.Move;
import javaee.solutions.pgn.base.entity.PGNGame;
import javaee.solutions.pgn.base.entity.Tag;
import javaee.solutions.pgn.base.enumeration.EColor;
import javaee.solutions.pgn.base.enumeration.EResult;
import javaee.solutions.pgn.generated.PGNBaseListener;
import javaee.solutions.pgn.generated.PGNParser;

/**
 * This listener collect game information from one PGN file.
 */
public class DataCollector extends PGNBaseListener implements IDataCollector {

    private final List<PGNGame> games = new ArrayList<>();

    private PGNGame actualGame;
    private Tag actualTag;
    private Move actualMove;

    @Override
    public List<PGNGame> getGames() {
        return games;
    }

    @Override
    public void enterGame(final PGNParser.GameContext ctx) {
        actualGame = new PGNGame();
    }

    @Override
    public void exitGame(final PGNParser.GameContext ctx) {
        games.add(actualGame);
    }

    @Override
    public void enterTag_pair(final PGNParser.Tag_pairContext ctx) {
        actualTag = new Tag();
    }

    @Override
    public void exitTag_pair(final PGNParser.Tag_pairContext ctx) {
        actualGame.addTag(actualTag);
    }

    @Override
    public void enterTag_name(final PGNParser.Tag_nameContext ctx) {
        actualTag.setName(ctx.getText());
    }

    @Override
    public void enterTag_value(final PGNParser.Tag_valueContext ctx) {
        actualTag.setValue(ctx.getText());
    }

    @Override
    public void enterMove_number(final PGNParser.Move_numberContext ctx) {
        final String moveNumber = ctx.getText();
        actualMove.setNumber(Integer.valueOf(moveNumber.replaceAll("\\.", "")));
        actualMove.setColor(moveNumber.contains("...") ? EColor.BLACK : EColor.WHITE);
    }

    @Override
    public void enterMove(final PGNParser.MoveContext ctx) {
        actualMove.setMove(ctx.getText());
    }

    @Override
    public void enterTime(final PGNParser.TimeContext ctx) {
        actualMove.setTime(ctx.getText());
    }

    @Override
    public void enterElement_sequence(final PGNParser.Element_sequenceContext ctx) {
        actualMove = new Move();
    }

    @Override
    public void exitElement_sequence(final PGNParser.Element_sequenceContext ctx) {
        actualGame.addMove(actualMove);
    }

    @Override
    public void enterGame_termination(final PGNParser.Game_terminationContext ctx) {
        actualGame.setResult(EResult.find(ctx.getText()));
    }

}
