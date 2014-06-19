package com.chess.exception;

/**
 * Exception for when a Piece is not found.
 *
 * @author William Martin
 * @since v0.0
 */
public class PieceNotFoundException extends Exception {

    /**
     * Default constructor.
     */
    public PieceNotFoundException() {
        super("Piece not found.");
    }

    /**
     * Specialised constructor.
     *
     * @param message the reason why this Exception was thrown.
     */
    public PieceNotFoundException(final String message) {
        super(message);
    }
}
