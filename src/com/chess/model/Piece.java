package com.chess.model;

import java.util.Set;

/**
 * Interface for pieces which defines how they can move.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Piece {

    /**
     * Computes the possible set of new positions the Piece could move to.
     *
     * @param position the current Position of the Piece.
     * @param board the Board that the Piece is on.
     * @return the possible set of new positions the Piece could move to.
     */
    public Set<Position> computePossibleMoves(final Position position,
                                              final Board board);

    /**
     * Gets the side of this Piece.
     *
     * @return the side of this Piece.
     */
    public int getSide();
}
