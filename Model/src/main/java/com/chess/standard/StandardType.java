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

    private StandardType(final int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
