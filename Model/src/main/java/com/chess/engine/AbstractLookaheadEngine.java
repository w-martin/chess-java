package com.chess.engine;

/**
 * Abstract {@link Engine} that uses a fixed lookahead range to plan the best
 * {@link com.chess.model.Move}.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractLookaheadEngine implements Engine {

    private final int lookahead;

    /**
     * Default constructor.
     *
     * @param lookahead the fixed lookahead range for planning moves.
     */
    public AbstractLookaheadEngine(final int lookahead) {
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
