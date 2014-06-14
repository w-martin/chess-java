package com.chess.standard;

/**
 * Represents a chess Piece type.
 *
 * @author William Martin
 * @since v0.0
 */
public enum StandardType {

    PAWN(1), BISHOP(3), KNIGHT(3), ROOK(5), QUEEN(9), KING(0);

    private int weight;

    /**
     * Default constructor.
     *
     * @param weight the weight of this piece.
     */
    private StandardType(final int weight) {
        this.weight = weight;
    }

    /**
     * Gets the weight of this piece.
     *
     * @return the weight of this piece.
     */
    public int getWeight() {
        return weight;
    }
}
