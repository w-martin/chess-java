package com.chess.standard;

import com.chess.game.AbstractMoveController;
import com.chess.model.Board;
import com.chess.model.Move;

import java.util.List;

/**
 * Standard chess implementation of {@link com.chess.game.MoveController}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardMoveController <T> extends AbstractMoveController <T> {

    public StandardMoveController(final Board board) {
        super(board);
    }

    @Override
    public List<Move> computeMoves(final Board board, final T side) {
        return null;
    }

    @Override
    public List<Move> getMoveHistory() {
        return null;
    }

    @Override
    public void makeMove(Move move) {

    }
}
