package javaee.solutions.pgn.base;

import java.util.List;

import javaee.solutions.pgn.base.entity.PGNGame;

/**
 * Interface to the data collector.
 */
public interface IDataCollector {

    List<PGNGame> getGames();
}
