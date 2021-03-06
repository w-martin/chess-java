package com.chess.engine;

import com.chess.game.MoveComputer;
import com.chess.game.MoveController;
import com.chess.model.Board;
import com.chess.model.Move;

import java.util.Random;
import java.util.List;

/**
 * {@link com.chess.engine.Engine} that makes moves randomly and should be
 * easily beaten.
 *
 * @author William Martin
 * @since v0.0
 */
public class RandomEngine <B extends Board<T, ?, ?>, T>
        extends AbstractEngine <B, T> {

    public RandomEngine(final MoveController <B, T> moveController,
                        final MoveComputer<B, T> moveComputer) {
        super(moveController, moveComputer);
    }

    @Override
    public Move move(final B board, final T side) {
        List<Move> moves = getMoveComputer().computeMoves(board, side);
        int choice = new Random().nextInt(moves.size());
        return moves.get(choice);
    }

    @Override
    public Assessment assess(final Board board) {
        return null;
    }
}
