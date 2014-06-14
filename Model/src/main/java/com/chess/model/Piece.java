package com.chess.model;

/**
 * Interface for pieces which defines how they can move.
 *
 * @param <T> team enum.
 * @param <Y> type enum.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Piece <T, Y> {

    /**
     * Checks if this Piece has moved.
     *
     * @return true if this Piece has moved, false otherwise.
     */
    public boolean checkHasMoved();

    /**
     * Gets the team of this Piece.
     *
     * @return the team of this Piece.
     */
    public T getTeam();

    /**
     * Gets the type of this Piece.
     *
     * @return the type of this Piece.
     */
    public Y getType();
}
