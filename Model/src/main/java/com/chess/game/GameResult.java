package com.chess.game;

import com.chess.exception.ResultWasDrawException;

/**
 * Represents the result of a chess game.
 *
 * @param T the team class.
 *
 * @author William Martin
 * @since v0.0
 */
public interface GameResult <T> {

    /**
     * Gets the integer representation of the team that won the game.
     *
     * @return the team that won the game.
     */
    public T getWinner() throws ResultWasDrawException;
}
