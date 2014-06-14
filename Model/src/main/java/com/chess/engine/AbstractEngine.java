package com.chess.engine;

import com.chess.game.MoveController;
import com.chess.game.Player;
import com.google.common.annotations.VisibleForTesting;

/**
 * Abstract {@link com.chess.engine.Engine} that references a
 * {@link com.chess.game.MoveController}.
 *
 * @param T the team class.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractEngine <T, Y> implements Engine, Player<T> {

    private final MoveController<T, Y> moveController;

    public AbstractEngine (final MoveController<T, Y> moveController) {
        this.moveController = moveController;
    }

    /**
     * Gets the {@link com.chess.game.MoveController} this
     * {@link com.chess.engine.Engine} uses.
     *
     * @return the {@link com.chess.game.MoveController} this
     * {@link com.chess.engine.Engine} uses.
     */
    @VisibleForTesting
    public MoveController<T, Y> getMoveController() {
        return moveController;
    }
}
