package com.chess.model;

/**
 * Represents a 2D position on a chess {@link Board}.
 *
 * @author William Martin
 * @since v0.0
 */
public class TwoDimensionalPosition {

    private final int x, y;

    /**
     * Default constructor.
     *
     * @param x the x coordinate.
     * @param y
     */
    public TwoDimensionalPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
