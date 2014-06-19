package com.chess.game;

import com.chess.model.Board;
import com.chess.model.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract {@link com.chess.game.MoveController} that keeps information on
 * Board and Move history.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractMoveController <B extends Board<T, ?, ?>, T>
        implements MoveController <B, T> {

    private final List<Move> moveHistory;
    private final B board;

    public  AbstractMoveController(final B board) {
        this.board = board;
        moveHistory = new ArrayList<>();
    }

    /**
     * Gets the {@link com.chess.model.Board} this MoveController is using.
     *
     * @return the {@link com.chess.model.Board} this MoveController is using.
     */
    public B getBoard() {
        return board;
    }

    @Override
    public List<Move> getMoveHistory() {
        return moveHistory;
    }
}
