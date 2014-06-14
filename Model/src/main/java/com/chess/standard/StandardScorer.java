package com.chess.standard;

import com.chess.engine.Scorer;
import com.chess.model.Board;
import com.chess.model.Piece;
import com.chess.standard.pieces.*;

import java.util.Map;
import java.util.Set;

/**
 * Scores a board using piece weights.
 */
public class StandardScorer implements Scorer {

    private static Map<Class, Integer> pieceValues;

    static {
        pieceValues.put(Pawn.class, 1);
        pieceValues.put(Knight.class, 3);
        pieceValues.put(Bishop.class, 3);
        pieceValues.put(Rook.class, 5);
        pieceValues.put(Queen.class, 9);
    }

    private int computeMaterialWeight(final Board board, final StandardSides side) {
        int score = 0;
        Set<Piece> pieces = board.getPieces(side.value());
        for (final Piece p : pieces) {
            score += pieceValues.get(p.getClass());
        }
        return score;
    }

    @Override
    public double score(final Board board, final int side) {
        int whiteWeight = computeMaterialWeight(board, StandardSides.WHITE);
        int blackWeight = computeMaterialWeight(board, StandardSides.BLACK);
        if (StandardSides.WHITE.value() == side) {
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
