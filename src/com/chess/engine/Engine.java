package com.chess.engine;

import com.chess.model.Board;
import com.chess.model.Move;

/**
 * Interface for a chess engine.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Engine {

    /**
     * Plans a move using the given {@link Board} and aims to complete in the
     * given time.
     *
     * @param board the Board to move to pieces on.
     * @param time the time to move under.
     * @return the computed {@link Move}.
     */
    public Move move(final Board board, final long time);

    /**
     * Produces an assessment of the given {@link Board}.
     *
     * @param board the Board to assess the state of.
     * @return the generated assessment.
     */
    public Assessment assess(final Board board);
}
