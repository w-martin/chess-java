package com.chess.standard.piece;

import com.chess.model.DefaultMove;
import com.chess.model.Move;
import com.chess.model.Position;
import com.chess.standard.*;
import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author William Martin
 * @since v0.0
 */
public class PawnMoveComputer extends StandardPieceMoveComputer {

    @Override
    public List<Move> computeMoves(final StandardBoard board,
                                         final StandardPiece object) {
        final List<Move> moves = new ArrayList<>();
        moves.addAll(computePawnMoveForward(board, object));
//                moves.addAll(computePawnMoveForwardDouble(p, board));
//                moves.addAll(computePawnTakeDiagonal(p, board));
//                moves.addAll(computePawnTakeEnPassant(p, board));
        return moves;
    }

    /**
     * Computes the moves that a pawn can execute going forwards.
     *
     * @param pawn the pawn.
     * @param board the board to move on
     * @return the moves that a pawn can execute going forwards.
     */
    @VisibleForTesting
    protected List<Move> computePawnMoveForward(final StandardBoard board,
                                                final StandardPiece pawn) {
        List<Move> moves = new ArrayList<>();
        Position position = board.getPosition(pawn);
        Position forward = new StandardPosition(position.getX(),
                position.getY() +
                        ((pawn.getTeam() == StandardTeam.WHITE) ? 1 : -1));
        boolean upgrade = forward.getY() ==
                ((pawn.getTeam() == StandardTeam.WHITE) ? 8 : 1);

        if (!board.checkSquareOccupied(forward)) {
            if (upgrade) {
                moves.add(new DefaultMove(pawn, forward,
                        new StandardPiece(pawn.getTeam(), StandardType.BISHOP)));
                moves.add(new DefaultMove(pawn, forward,
                        new StandardPiece(pawn.getTeam(), StandardType.KNIGHT)));
                moves.add(new DefaultMove(pawn, forward,
                        new StandardPiece(pawn.getTeam(), StandardType.ROOK)));
                moves.add(new DefaultMove(pawn, forward,
                        new StandardPiece(pawn.getTeam(), StandardType.QUEEN)));
            } else {
                moves.add(new DefaultMove(pawn, forward));
            }
        }
        return moves;
    }
}
