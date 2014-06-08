package com.chess.model;

/**
 * Abstract {@link Piece} with an allegiance.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractPiece implements Piece {

    private final int side;
    private boolean hasMoved;

    /**
     * Default constructor.
     *
     * @param side the team of this {@link Piece}.
     */
    public AbstractPiece(final int side) {
        this.side = side;
        this.hasMoved = false;
    }

    @Override
    public boolean checkHasMoved() {
        return hasMoved;
    }

    /**
     * Gets the side of this {@link Piece}.
     *
     * @return the side of this {@link Piece}.
     */
    public int getTeam() {
        return side;
    }
}
