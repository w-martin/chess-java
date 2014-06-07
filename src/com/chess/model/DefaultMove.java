package com.chess.model;

/**
 * Default {@link Move} where a {@link Piece} can change {@link Position} and
 * upgrade.
 *
 * @author William Martin
 * @since v0.0
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
     * @param newPosition he place to move the Piece to.
     * @param upgradedPiece the new Piece.
     */
    public DefaultMove(final Piece piece, final Position newPosition,
                       final Piece upgradedPiece) {
        this(piece, newPosition);
        this.upgradedPiece = upgradedPiece;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }

    @Override
    public Position getNewPosition() {
        return newPostition;
    }

    @Override
    public boolean checkUpgraded() {
        return null != upgradedPiece;
    }

    @Override
    public Piece getUpgradedPiece() {
        return upgradedPiece;
    }
}
