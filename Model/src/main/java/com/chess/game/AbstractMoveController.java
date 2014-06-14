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
public abstract class AbstractMoveController <T, Y> implements MoveController <T, Y> {

    private final List<Move> moveHistory;
    private final Board<T, Y> board;

    public  AbstractMoveController(final Board<T, Y> board) {
        this.board = board;
        moveHistory = new ArrayList<>();
    }

    /**
     * Gets the {@link com.chess.model.Board} this MoveController is using.
     *
     * @return the {@link com.chess.model.Board} this MoveController is using.
     */
    public Board<T, Y> getBoard() {
        return board;
    }

    @Override
    public List<Move> getMoveHistory() {
        return moveHistory;
    }
}
