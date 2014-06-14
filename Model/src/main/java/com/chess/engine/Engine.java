package com.chess.engine;

import com.chess.model.Board;

/**
 * Interface for a chess engine.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Engine {

    /**
     * Produces an assessment of the given {@link Board}.
     *
     * @param board the Board to assess the state of.
     * @return the generated assessment.
     */
    public Assessment assess(final Board board);
}
