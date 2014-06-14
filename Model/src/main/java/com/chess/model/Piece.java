package com.chess.model;

import java.util.Collection;
import java.util.List;

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
    public Collection<Move> computePossibleMoves(final Position position,
                                                 final Board board);

    /**
     * Gets the team of this Piece.
     *
     * @return the team of this Piece.
     */
    public int getTeam();

    /**
     * Gets the list of opposing teams for this Piece.
     *
     * @return the list of opposing teams for this Piece.
     */
    public List<Integer> getOpposingTeams();

    /**
     * Checks if this Piece has moved.
     *
     * @return true if this Piece has moved, false otherwise.
     */
    public boolean checkHasMoved();
}
