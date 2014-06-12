package com.chess.engine;

import com.chess.model.Board;

/**
 * Interface for metrics used to measure the success of different sides of the
 * game.
 *
 * @author William Martin
 */
public interface Scorer {

    /**
     * Scores the given {@link Board}.
     *
     * @param board the Board to score.
     * @return the computed score.
     */
    public double score(final Board board);
}
