package com.chess.model;

import java.util.List;
import java.util.Set;

/**
 * Basic chess board interface.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Board <T, Y> {

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
    public Set<Piece<T, Y>> getPieces();

    /**
     * Gets the pieces on this board.
     *
     * @param side the side to filter pieces for.
     * @return the pieces on this board.
     */
    public Set<Piece<T, Y>> getPieces(final T side);

    /**
     * Gets the {@link Piece} at the given {@link Position}.
     *
     * @param position the Position to check for.
     * @return the Piece at the given Position, or null if the Position is
     * empty.
     */
    public Piece<T, Y> getPieceAtPosition(final Position position);

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

    /**
     * Checks whether the given position is in the bounds of this Board.
     *
     * @param position the Position to check for.
     * @return true if the Position is in bounds, false otherwise.
     */
    public boolean checkPositionInBounds(final Position position);

    /**
     * Checks whether the given Position if covered by the given team.
     *
     * @param position the Position to check.
     * @param team the team to check for.
     * @return true if the given Position if covered by the given team, false
     * otherwise.
     */
    public boolean checkSquareCoveredByTeam(final Position position,
                                            final T team);

    /**
     * Checks whether the given Position if occupied by the given team.
     *
     * @param position the Position to check.
     * @param team the team to check for.
     * @return true if the given Position if occupied by the given team, false
     * otherwise.
     */
    public boolean checkSquareOccupiedByTeam(final Position position,
                                             final T team);

    /**
     * Checks whether the given square is occupied.
     *
     * @param position the Position to check for.
     * @return true if the given square is occupied, false otherwise.
     */
    public boolean checkSquareOccupied(final Position position);

    /**
     * Gets the number of pieces of the given side.
     *
     * @param side the side to check for.
     * @return the number of pieces of the given side.
     */
    public int getNoPieces(final T side);
}
