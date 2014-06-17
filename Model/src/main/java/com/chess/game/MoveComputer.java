package com.chess.game;

import com.chess.model.Board;
import com.chess.model.Move;

import java.util.List;

/**
 * Computes moves.
 *
 * @author William Martin
 * @since v0.0
 */
public interface MoveComputer <B extends Board, S> {

    /**
     * Computes the possible moves for the given object
     * on the given {@link com.chess.model.Board}.
     *
     * @param board the Board to compute moves on.
     * @param object the object to compute moves for.
     * @return the computes moves.
     */
    public List<Move> computeMoves(final B board, final S object);
}
