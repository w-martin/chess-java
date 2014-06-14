package com.chess.standard;

import com.chess.engine.Scorer;
import com.chess.model.Board;
import com.chess.model.Piece;

import java.util.Map;
import java.util.Set;

/**
 * Scores a board using piece weights.
 */
public class StandardScorer implements Scorer <StandardTeam> {

    private int computeMaterialWeight(final Board board, final StandardTeam side) {
        int score = 0;
        Set<Piece<StandardTeam, StandardType>> pieces = board.getPieces(side);
        for (final Piece<StandardTeam, StandardType> p : pieces) {
            score += p.getType().getWeight();
        }
        return score;
    }

    @Override
    public double score(final Board board, final StandardTeam side) {
        int whiteWeight = computeMaterialWeight(board, StandardTeam.WHITE);
        int blackWeight = computeMaterialWeight(board, StandardTeam.BLACK);
        if (StandardTeam.WHITE == side) {
            return whiteWeight - blackWeight;
        } else {
            return  blackWeight - whiteWeight;
        }
//        int numWhitePieces = board.getNoPieces(StandardSides.WHITE.value());
//        int numBlackPieces = board.getNoPieces(StandardSides.BLACK.value());
//        int who2move = (StandardSides.BLACK.value() == side) ? -1 : 1;
//        int score = materialWeight * (numWhitePieces - numBlackPieces) * who2move;
//        return score;
    }
}
