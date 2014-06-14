package com.chess.model;

/**
 * Basic implementation of {@link Board} interface. Makes no assumptions on
 * board size, see instead {@link com.chess.standard.StandardBoard}.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractBoard <T, Y> implements Board <T, Y> {

    private final int height;
    private final int width;

    /**
     * Default constructor.
     *
     * @param width board width in squares.
     * @param height board height in squares.
     */
    protected AbstractBoard(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
