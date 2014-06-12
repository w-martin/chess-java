package com.chess.model;

/**
 * @author William Martin
 */
public class DefaultMove implements Move {

    private final Piece piece;
    private final Position newPostition;
    private Piece upgradedPiece;

    /**
     * Default constructor.
     *
     * @param piece the Piece to move.
     * @param newPosition the place to move the Piece to.
     */
    public DefaultMove(final Piece piece, final Position newPosition) {
        this.piece = piece;
        this.newPostition = newPosition;
    }

    /**
     * Specialised constructor for upgrade cases.
     *
     * @param piece the piece moving and upgrading.
     * @param newPosition th
     * @param upgradedPiece
     */
    public DefaultMove(final Piece piece, final Position newPosition, Piece upgradedPiece) {
        this(piece, newPosition);
        this.upgradedPiece = upgradedPiece;
    }
}
