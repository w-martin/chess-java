package com.chess.model;

import java.util.Collection;
import java.util.Set;

/**
 * Abstract {@link Piece} with an allegiance.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractPiece implements Piece {

    private final int side;
    private boolean hasMoved;
    private Position position;
    private final Board board;

    /**
     * Default constructor.
     *
     * @param side the team of this {@link Piece}.
     */
    public AbstractPiece(final int side, final Board board) {
        this.side = side;
        this.hasMoved = false;
        this.board = board;
    }

    /**
     * Computes the possible set of new positions the Piece could move to.
     *
     * @return the possible set of new positions the Piece could move to.
     */
    public Collection<Move> computePossibleMoves() {
        return computePossibleMoves(getPosition(), getBoard());
    }

    @Override
    public boolean checkHasMoved() {
        return hasMoved;
    }

    /**
     * Gets the board that holds this Piece.
     *
     * @return the board that holds this Piece.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gets the Position of this Piece.
     *
     * @return the Position of this Piece.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets the side of this {@link Piece}.
     *
     * @return the side of this {@link Piece}.
     */
    public int getTeam() {
        return side;
    }

    /**
     * Sets the Position of this Piece.
     *
     * @param position the Position of this Piece.
     */
    public void setPosition(final Position position) {
        this.position = position;
}
