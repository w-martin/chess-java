package com.chess.engine;

import com.chess.model.Board;

/**
 * Interface for metrics used to measure the success of different sides of the
 * game.
 *
 * @author William Martin
 */
public interface Scorer <T> {

    /**
     * Scores the given {@link Board}.
     *
     * @param board the Board to score.
     * @param side the side to score for.
     * @return the computed score.
     */
    public double score(final Board board, final T side);
}
