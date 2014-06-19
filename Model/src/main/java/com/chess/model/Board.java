package com.chess.model;

import com.chess.exception.PieceNotFoundException;
import com.chess.exception.PositionTakenException;

import java.util.Set;

/**
 * Basic chess board interface.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Board<T, Y, P extends Piece<T, Y>> {

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
    public Set<P> getPieces();

    /**
     * Gets the pieces on this board.
     *
     * @param side the side to filter pieces for.
     * @return the pieces on this board.
     */
    public Set<P> getPieces(final T side);

    /**
     * Gets the {@link Piece} at the given {@link Position}.
     *
     * @param position the Position to check for.
     * @return the Piece at the given Position, or null if the Position is
     * empty.
     */
    public P getPieceAtPosition(final Position position);

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
     * @param piece    the Piece to add.
     */
    public void addPieceToPosition(final Position position, final P piece) throws PositionTakenException;

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
     * @param team     the team to check for.
     * @return true if the given Position if covered by the given team, false
     * otherwise.
     */
    public boolean checkSquareCoveredByTeam(final Position position,
                                            final T team);

    /**
     * Checks whether the given Position if occupied by the given team.
     *
     * @param position the Position to check.
     * @param team     the team to check for.
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


    /**
     * Gets the number of pieces.
     *
     * @return the number of pieces.
     */
    public int getNoPieces();

    /**
     * Gets the {@link com.chess.model.Position} of the given
     * {@link com.chess.model.Piece}.
     *
     * @param piece the Piece to get the Position for.
     * @return the Position of the given Piece.
     * @throws com.chess.exception.PieceNotFoundException if the Piece was not
     *                                                found.
     */
    public Position getPosition(final P piece) throws PieceNotFoundException;

    /**
     * Gets the {@link com.chess.model.Position} of the given
     * team and type.
     *
     * @param pieceTeam the team of Piece to get the Position for.
     * @param pieceType the type of Piece to get the Position for.
     * @return the Position of the given Piece team and type.
     * @throws com.chess.exception.PieceNotFoundException if the Piece was not
     *                                                found.
     */
    public Position getPosition(final T pieceTeam, final Y pieceType)
            throws PieceNotFoundException;

    /**
     * Gets this Board after the given Move is executed.
     *
     * @param move the move to execute.
     */
    public Board<T, Y, P> getUpdatedBoard(final Move move);
}
