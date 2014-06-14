package com.chess.game;

/**
 * Represents the result of a chess game.
 *
 * @author William Martin
 * @since v0.0
 */
public interface GameResult {

    /**
     * Gets the integer representation of the team that won the game.
     *
     * @return the team that won the game.
     */
    public int getWinner() throws ResultWasDrawException;
}
