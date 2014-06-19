package com.chess.model;

/**
 * Basic implementation of {@link Board} interface. Makes no assumptions on
 * board size.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractBoard <T, Y, P extends Piece<T, Y>>
        implements Board <T, Y, P> {

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
