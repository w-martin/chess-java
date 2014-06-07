package com.chess.model;

/**
 * Interface for a chess move.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Move {

    /**
     * Gets the {@link Piece} that is moving.
     *
     * @return the {@link Piece} that is moving.
     */
    public Piece getPiece();

    /**
     * Gets the {@link Position} that the Piece is moving to.
     *
     * @return the {@link Position} that the Piece is moving to.
     */
    public Position getNewPosition();

    /**
     * Checks if the Piece is being upgraded.
     *
     * @return True if the Piece is being upgraded, False otherwise.
     */
    public boolean checkUpgraded();

    /**
     * Gets the Piece to upgrade to.
     *
     * @return the Piece to upgrade to, if an upgrade is taking place, NULL otherwise.
     */
    public Piece getUpgradedPiece();
}
