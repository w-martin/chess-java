package com.chess.model;

import java.util.List;

/**
 * Basic chess board interface.
 *
 * @author William Martin
 * @since v0.0
 */
public interface Board {

    /**
     * Gets the width of this board in squares.
     *
     * @return the width of this board in squares.
     */
    public int getWidth();

    /**
     * Gets the height of this board in squares.
     *
     * @return the height of this board in squares.
     */
    public int getHeight();

    /**
     * Gets the pieces on this board.
     *
     * @return the pieces on this board.
     */
    public List<Piece> getPieces();
}
