package com.chess.game;

import com.chess.model.Board;
import com.chess.model.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract {@link com.chess.game.MoveController} that keeps information on
 * Board and Move history.
 *
 * @param T the team class.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractMoveController <T> implements MoveController <T> {

    private final List<Move> moveHistory;
    private final Board board;

    public  AbstractMoveController(final Board board) {
        this.board = board;
        moveHistory = new ArrayList<>();
    }

    /**
     * Gets the {@link com.chess.model.Board} this MoveController is using.
     *
     * @return the {@link com.chess.model.Board} this MoveController is using.
     */
    public Board getBoard() {
        return board;
    }
}
