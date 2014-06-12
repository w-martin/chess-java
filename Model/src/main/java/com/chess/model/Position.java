package com.chess.model;

/**
 * Represents a 2D position on a chess {@link Board}.
 *
 * @author William Martin
 * @since v0.0
 */
public class Position {

    private final int x, y;

    /**
     * Default constructor.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x coordinate.
     *
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y coordinate.
     *
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }
}
