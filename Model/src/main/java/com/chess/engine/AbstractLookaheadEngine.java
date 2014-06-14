package com.chess.engine;

import com.chess.game.MoveController;

/**
 * Abstract {@link Engine} that uses a fixed lookahead range to plan the best
 * {@link com.chess.model.Move}.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractLookaheadEngine <T, Y> extends
        AbstractEngine <T, Y> {

    private final int lookahead;

    public AbstractLookaheadEngine(MoveController<T, Y> moveController,
                                   final int lookahead) {
        super(moveController);
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
