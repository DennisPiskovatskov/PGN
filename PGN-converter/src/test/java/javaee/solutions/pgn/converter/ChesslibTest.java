package javaee.solutions.pgn.converter;

import org.junit.jupiter.api.Test;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.game.Game;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveList;
import com.github.bhlangonijr.chesslib.pgn.PgnHolder;

import javaee.solutions.pgn.chessclub.ChessclubConstants;

/**
 * An experiment with {@link https://github.com/bhlangonijr/chesslib}.
 */
public class ChesslibTest {

    @Test
    public void tryMe() throws Exception {
        // WORK: PlaychessConstants.PGN1_EXTERNAL
        // DOESN'T WORK: LichessConstants.PGN1_EXTERNAL
        // WORK: ChessConstants.PGN4_EXTERNAL
        // DOESN'T WORK: ChessclubConstants.PGN1_EXTERNAL
        final PgnHolder pgn = new PgnHolder(ChessclubConstants.PGN1_EXTERNAL);
        pgn.loadPgn();
        for (final Game game : pgn.getGame()) {
            game.loadMoveText();
            final MoveList moves = game.getHalfMoves();
            final Board board = new Board();
            // Replay all the moves from the game and print the final position in FEN format
            for (final Move move : moves) {
                board.doMove(move);
            }
            System.out.println("FEN: " + board.getFen());
        }
    }

}
