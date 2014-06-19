package com.chess.engine;

import com.chess.game.MoveComputer;
import com.chess.game.MoveController;
import com.chess.game.Player;
import com.chess.model.Board;
import com.google.common.annotations.VisibleForTesting;

/**
 * Abstract {@link com.chess.engine.Engine} that references a
 * {@link com.chess.game.MoveController}.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractEngine <B extends Board<T, ?, ?>, T>
        implements Engine, Player<B, T> {

    private final MoveController<B, T> moveController;
    private final MoveComputer<B, T> moveComputer;

    public AbstractEngine (final MoveController<B, T> moveController,
                           final MoveComputer<B, T> moveComputer) {
        this.moveController = moveController;
        this.moveComputer = moveComputer;
    }

    /**
     * Gets the {@link com.chess.game.MoveController} this
     * {@link com.chess.engine.Engine} uses.
     *
     * @return the {@link com.chess.game.MoveController} this
     * {@link com.chess.engine.Engine} uses.
     */
    @VisibleForTesting
    public MoveController<B, T> getMoveController() {
        return moveController;
    }

    /**
     * Gets the {@link com.chess.game.MoveComputer} this
     * {@link com.chess.engine.Engine} uses.
     *
     * @return the {@link com.chess.game.MoveComputer} this
     * {@link com.chess.engine.Engine} uses.
     */
    @VisibleForTesting
    public MoveComputer<B, T> getMoveComputer() {
        return moveComputer;
    }
}
