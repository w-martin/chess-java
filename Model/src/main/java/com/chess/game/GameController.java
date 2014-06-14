package com.chess.game;

/**
 * Acts as the controller for a chess game.
 *
 * @author William Martin
 * @since v0.0
 */
public interface GameController {

    /**
     * Executes a game of chess.
     *
     * @return the result of the game.
     */
    public GameResult playGame();
}
