package com.chess.game;

/**
 * @author William Martin
 */
public class AbstractGameController {
    private static AbstractGameController ourInstance = new AbstractGameController();

    public static AbstractGameController getInstance() {
        return ourInstance;
    }

    protected AbstractGameController() {
    }
}
