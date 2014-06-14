package com.chess.engine;

import com.chess.model.Board;
import com.chess.model.Move;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * Chooses the move which results in the best negamax score.
 * Ignores time.
 */
public class NegamaxEngine extends AbstractLookaheadEngine {

    private final Scorer scorer;

    public NegamaxEngine(final int lookahead, final Scorer scorer) {
        super(lookahead);
        this.scorer = scorer;
    }

    @Override
    public Move move(final Board board, final int side) {

    }

    @Override
    public Assessment assess(Board board) {
        return null;
    }

    public Pair<Integer, Move> negaMax(final int depth, final Board board, final int side) {
        if (0 == depth) {
            return scorer.score(board, side);
        }
        final List<Move> moves = board.getPossibleMoves(side);
        Pair<Integer, Move> max = Pair.of(Integer.MIN_VALUE, null);
        for (final Move m : moves) {
            final Pair<Integer, Move> result = -negaMax(depth - 1, m.getNewBoard(), side);
            if (result.getLeft() > max.getLeft()) {
                max = result;
            }
        }
        return max;
    }
}
