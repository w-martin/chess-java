package com.chess.game;

import com.chess.model.Board;
import com.chess.model.Move;

/**
 * Represents a player.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Player <B extends Board<T, ?, ?>, T> {

    /**
     * Plans a move using the given {@link com.chess.model.Board} and aims to
     * complete in the given time.
     *
     * @param board the Board to move to pieces on.
     * @param side the team to move.
     * @return the computed {@link com.chess.model.Move}.
     */
    public Move move(final B board, final T side);
}
