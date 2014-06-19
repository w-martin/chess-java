package com.chess.exception;

/**
 * Exception for when a position is taken.
 *
 * @author William Martin
 * @since v0.0
 */
public class PositionTakenException extends Exception {

    /**
     * Default constructor.
     */
    public PositionTakenException() {
        super("Error. Position already taken.");
    }

    /**
     * Specialised constructor.
     *
     * @param message the cause of this Exception.
     */
    public PositionTakenException(final String message) {
        super(message);
    }
}
