package com.chess.engine;

import com.chess.game.MoveController;
import com.chess.model.Board;
import com.chess.model.Move;

import java.util.Random;
import java.util.List;

/**
 * {@link com.chess.engine.Engine} that makes moves randomly and should be
 * easily beaten.
 *
 * @param T the team class.
 *
 * @author William Martin
 * @since v0.0
 */
public class RandomEngine <T> extends AbstractEngine <T> {

    public RandomEngine(final MoveController <T> moveController) {
        super(moveController);
    }

    @Override
    public Move move(final Board board, final T side) {
        List<Move> moves = getMoveController().computeMoves(board, side);
        int choice = new Random().nextInt(moves.size());
        return moves.get(choice);
    }

    @Override
    public Assessment assess(final Board board) {
        return null;
    }
}
