package com.chess.game;

/**
 * Exception used when a win or loss was expected but the result was a draw.
 *
 * @author William Martin
 * @since v0.0
 */
public class ResultWasDrawException extends Exception {

    /**
     * Specialised constructor.
     *
     * @param message the cause of this Exception.
     */
    public ResultWasDrawException(final String message) {
        super(message);
    }

    /**
     * Default constructor.
     */
    public ResultWasDrawException() {
        super("Error. Result was a draw.");
    }
}
