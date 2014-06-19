package com.chess.engine;

import com.chess.game.MoveComputer;
import com.chess.game.MoveController;
import com.chess.model.Board;

/**
 * Abstract {@link Engine} that uses a fixed lookahead range to plan the best
 * {@link com.chess.model.Move}.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractLookaheadEngine <B extends Board<T, ?, ?>, T> extends
        AbstractEngine <B, T> {

    private final int lookahead;

    public AbstractLookaheadEngine(MoveController<B, T> moveController,
                                   MoveComputer<B, T> moveComputer,
                                   final int lookahead) {
        super(moveController, moveComputer);
        this.lookahead = lookahead;
    }

    /**
     * Gets the lookahead range for planning moves.
     *
     * @return the lookahead range for planning moves.
     */
    public int getLookahead() {
        return lookahead;
    }
}
