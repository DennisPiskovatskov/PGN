package javaee.solutions.pgn.converter;

import org.junit.jupiter.api.Test;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.game.Game;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveConversionException;
import com.github.bhlangonijr.chesslib.move.MoveList;
import com.github.bhlangonijr.chesslib.pgn.PgnHolder;

import javaee.solutions.pgn.chess.ChessConstants;

/**
 * An experiment with {@link https://github.com/bhlangonijr/chesslib}.
 */
public class ChesslibTest {

    @Test
    public void tryMe() throws Exception {
        // WORK: PlaychessConstants.PGN1_EXTERNAL -- Ignored:0/Imported:76
        // DOESN'T WORK: PlaychessConstants.PGN2_EXTERNAL -- Ignored: 14/Imported: 5976
        // DOESN'T WORK: LichessConstants.PGN1_EXTERNAL 50/50 -- Ignored:55/Imported:49
        // WORK: ChessConstants.PGN2_EXTERNAL -- Ignored:0/Imported: 50
        // WORK: ChessConstants.PGN3_EXTERNAL -- Ignored:0/Imported: 50
        // WORK: ChessConstants.PGN4_EXTERNAL -- Ignored:0/Imported: 50
        // DOESN'T WORK: ChessclubConstants.PGN1_EXTERNAL -- Ignored:267/Imported:1043
        final PgnHolder pgn = new PgnHolder(ChessConstants.PGN3_EXTERNAL);
        int ignored = 0;
        int imported = 0;
        pgn.loadPgn();
        for (final Game game : pgn.getGame()) {
            try {
                game.loadMoveText();
            } catch (final MoveConversionException ex) {
                ++ignored;
                continue; // NOTE: ignore partie
            }
            final MoveList moves = game.getHalfMoves();
            final Board board = new Board();
            // Replay all the moves from the game and print the final position in FEN format
            for (final Move move : moves) {
                board.doMove(move);
            }
            System.out.println("FEN: " + board.getFen());
            // System.out.println(board);
            ++imported;
        }

        System.out.println("Ignored: " + ignored);
        System.out.println("Imported: " + imported);
    }

}
