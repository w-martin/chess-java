package com.chess.standard.move;

import com.chess.game.MoveComputer;
import com.chess.model.Move;
import com.chess.standard.StandardBoard;
import com.chess.standard.StandardPiece;
import com.chess.standard.StandardTeam;
import com.chess.standard.StandardType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Computes moves for a standard team.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardMoveComputer implements
        MoveComputer<StandardBoard, StandardTeam> {

    private final Map<StandardType, MoveComputer> moveControllers;

    public StandardMoveComputer() {
        moveControllers = new HashMap<>(6);
        moveControllers.put(StandardType.PAWN, new PawnMoveComputer());
    }

    @Override
    public List<Move> computeMoves(final StandardBoard board,
                                   final StandardTeam side) {
        final List<Move> moves = new ArrayList<>();
        for (final StandardPiece p : board.getPieces(side)) {
            moves.addAll(moveControllers.get(p.getType()).computeMoves(board, p));
        }
        return moves;
    }
}
