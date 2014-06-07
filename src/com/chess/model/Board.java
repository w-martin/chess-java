package com.chess.model;

import java.util.Set;

/**
 * Basic chess board interface.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Board {

    /**
     * Gets the width of this board in squares.
     *
     * @return the width of this board in squares.
     */
    public int getWidth();

    /**
     * Gets the height of this board in squares.
     *
     * @return the height of this board in squares.
     */
    public int getHeight();

    /**
     * Gets the pieces on this board.
     *
     * @return the pieces on this board.
     */
    public Set<Piece> getPieces();

    /**
     * Gets the {@link Piece} at the given {@link Position}.
     *
     * @param position the Position to check for.
     * @return the Piece at the given Position, or null if the Position is
     * empty.
     */
    public Piece getPieceAtPosition(final Position position);

    /**
     * Removes the {@link Piece} at the given {@link Position}.
     *
     * @param position the Position of the Piece to remove.
     */
    public void removePieceAtPosition(final Position position);

    /**
     * Adds the given {@link Piece} to the Board at the given {@link Position}.
     *
     * @param position the Position to add the Piece at.
     * @param piece the Piece to add.
     */
    public void addPieceToPosition(final Position position, final Piece piece);
}
