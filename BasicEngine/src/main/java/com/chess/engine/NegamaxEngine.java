package com.chess.engine;

import com.chess.game.MoveComputer;
import com.chess.game.MoveController;
import com.chess.model.Board;
import com.chess.model.Move;
import com.chess.standard.StandardBoard;
import com.chess.standard.StandardTeam;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Chooses the move which results in the best negamax score.
 * Ignores time.
 */
public abstract class NegamaxEngine extends AbstractLookaheadEngine
        <StandardBoard, StandardTeam> {

    private final Scorer scorer;

    public NegamaxEngine(final MoveController<StandardBoard, StandardTeam> moveController,
                         final MoveComputer<StandardBoard, StandardTeam> moveComputer,
                         final int lookahead, final Scorer scorer) {
        super(moveController, moveComputer, lookahead);
        this.scorer = scorer;
    }

    @Override
    public Assessment assess(Board board) {
        return null;
    }

    public Pair<Integer, Move> negaMax(final int depth, final Move move, final int side) {
//        if (0 == depth) {
//            return scorer.score(move.getNewBoard(), side);
//        }
//        final List<Move> moves =
//        Pair<Integer, Move> max = Pair.of(Integer.MIN_VALUE, null);
//        for (final Move m : moves) {
//            final Pair<Integer, Move> result = -negaMax(depth - 1, m, side);
//            if (result.getLeft() > max.getLeft()) {
//                max = result;
//            }
//        }
//        return max;
        return  null;
    }
}
