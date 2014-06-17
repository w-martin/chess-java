package com.chess.standard;

import com.chess.game.AbstractMoveController;
import com.chess.model.*;
import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Standard chess implementation of {@link com.chess.game.MoveController}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardMoveController extends AbstractMoveController <StandardTeam, StandardType> {

    public StandardMoveController(final Board<StandardTeam, StandardType> board) {
        super(board);
    }

    @Override
    public List<Move> computeMoves(final Board<StandardTeam, StandardType> board, final StandardTeam side) {
        List<Move> moves = new ArrayList<>();
        for (final Piece<StandardTeam, StandardType> p : board.getPieces(side)) {
            moves.addAll(computeMoves(p, board));
        }
        return moves;
    }

    private Collection<Move> computeMoves(final Piece<StandardTeam, StandardType> p,
                                          final Board<StandardTeam, StandardType> board) {
        List<Move> moves = new ArrayList<>();
        switch (p.getType()) {
            case PAWN:
                moves.addAll(computePawnMoveForward(p, board));
//                moves.addAll(computePawnMoveForwardDouble(p, board));
//                moves.addAll(computePawnTakeDiagonal(p, board));
//                moves.addAll(computePawnTakeEnPassant(p, board));
                break;
            case BISHOP:
//                Set<Position> positions = new HashSet<Position>();
//                int x, y;
//                Position p;
//                for (int i = -1; i <= 1; i+=2) {
//                    for (int j = -1; j <= 1; j+=2) {
//                        x = position.getX();
//                        y = position.getY();
//                        do {
//                            x += i;
//                            y += j;
//                            p = new StandardPosition(x, y);
//                        } while (addValidMoveToSet(p, board, positions));
//                    }
//                }
//                return positions;
//            private boolean addValidMoveToSet(final Position position,
//            final Board board,
//            final Set<Position> positions) {
//                boolean shouldContinue = false;
//                try {
//                    Piece p = board.getPieceAtPosition(position);
//                    if (null == p) {
//                        shouldContinue = true;
//                        positions.add(position);
//                    } else if (p.getTeam() != this.getTeam()) {
//                        positions.add(position);
//                    }
//                } catch (final IndexOutOfBoundsException e) {
//                }
//                return shouldContinue;
//            }
                break;
            case KNIGHT:
                break;
            case ROOK:
//                Set<Position> positions = new HashSet<Position>();
//                int x, y;
//                Position p;
//                for (int i = -1; i <= 1; i+=2) {
//                    x = position.getX();
//                    y = position.getY();
//                    do {
//                        x += i;
//                        p = new StandardPosition(x, y);
//                    } while (addValidMoveToSet(p, board, positions));
//                    x = position.getX();
//                    do {
//                        y += i;
//                        p = new StandardPosition(x, y);
//                    } while (addValidMoveToSet(p, board, positions));
//                }
//                return positions;
//        private boolean addValidMoveToSet(final Position position,
//        final Board board,
//        final Set<Position> positions) {
//            boolean shouldContinue = false;
//            try {
//                Piece p = board.getPieceAtPosition(position);
//                if (null == p) {
//                    shouldContinue = true;
//                    positions.add(position);
//                } else if (p.getTeam() != this.getTeam()) {
//                    positions.add(position);
//                }
//            } catch (final IndexOutOfBoundsException e) {
//            }
//            return shouldContinue;
                break;
            case QUEEN:
//                Set<Position> positions = new HashSet<Position>();
//                int x, y;
//                Position p;
//                for (int i = -1; i <= 1; i+=2) {
//                    x = position.getX();
//                    y = position.getY();
//                    do {
//                        x += i;
//                        p = new StandardPosition(x, y);
//                    } while (addValidMoveToSet(p, board, positions));
//                    x = position.getX();
//                    do {
//                        y += i;
//                        p = new StandardPosition(x, y);
//                    } while (addValidMoveToSet(p, board, positions));
//                }
//                for (int i = -1; i <= 1; i+=2) {
//                    for (int j = -1; j <= 1; j+=2) {
//                        x = position.getX();
//                        y = position.getY();
//                        do {
//                            x += i;
//                            y += j;
//                            p = new StandardPosition(x, y);
//                        } while (addValidMoveToSet(p, board, positions));
//                    }
//                }
//                return positions;
//        private boolean addValidMoveToSet(final Position position,
//        final Board board,
//        final Set<Position> positions) {
//            boolean shouldContinue = false;
//            try {
//                Piece p = board.getPieceAtPosition(position);
//                if (null == p) {
//                    shouldContinue = true;
//                    positions.add(position);
//                } else if (p.getTeam() != this.getTeam()) {
//                    positions.add(position);
//                }
//            } catch (final IndexOutOfBoundsException e) {
//            }
//            return shouldContinue;
                break;
            case KING:
//                Set<Position> positions = new HashSet<Position>();
//                int x = position.getX();
//                int y = position.getY();
//                for (int j = -1; j <= 1; j++) {
//                    for (int i = -1; i <= 1; i++) {
//                        if (!(0 == i && 0 ==j)) {
//                            addValidMoveToSet(new StandardPosition(x + i, y + j),
//                                    board, positions);
//                        }
//                    }
//                }
//                if (!this.checkHasMoved()) {
//                    addCastleMoves(position, board, positions);
//                }
//                return positions;
//        private void addCastleMoves(final Position position,
//        final Board board,
//        final Set<Position> positions) {
//            int x = position.getX();
//            int y = position.getY();
//            // left
//            for (int i = -3; i <= -1; i++) {
//                if (!board.checkSquareOccupied(new StandardPosition(x + i, y))) {
//                    break;
//                }
//            }
//            // right
//            for (int i = 1; i <= 2; i++) {
//                if (!board.checkSquareOccupied(new StandardPosition(x + i, y))) {
//                    break;
//                }
//            }
//        private boolean addValidMoveToSet(final Position position,
//        final Board board,
//        final Set<Position> positions) {
//            boolean shouldContinue = false;
//            if (board.checkPositionInBounds(position)
//                    && !board.checkSquareOccupiedByTeam(position, this.getTeam())
//                    && !board.checkSquareCoveredByTeam(position,
//                    this.getOpposingTeams().get(0))) {
//                positions.add(position);
//            }
//            return shouldContinue;
                break;
        }
        filterForCheck(board, moves);
        return moves;
    }

    /**
     * Filters the given set of moves for those that would put the team in
     * check.
     * @TODO this should be replaced by a java 8 lambda expression
     *
     * @param board the Board to use.
     * @param moves the moves to filter.
     */
    private void filterForCheck(final Board<StandardTeam, StandardType> board,
                                List<Move> moves) {
        for (final Move<StandardTeam, ?> m : moves) {
            if (isInCheck(board.getUpdatedBoard(m), m.getPiece().getTeam())) {
                moves.remove(m);
            }
        }
    }

    @Override
    public boolean isInCheck(final Board<StandardTeam, StandardType> board,
                             final StandardTeam team) {
        return false;
    }

    /**
     * Computes the moves that a pawn can execute going forwards.
     *
     * @param pawn the pawn.
     * @param board the board to move on
     * @return the moves that a pawn can execute going forwards.
     */
    @VisibleForTesting
    protected List<Move> computePawnMoveForward(
            final Piece<StandardTeam, StandardType> pawn,
            final Board<StandardTeam, StandardType> board) {
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

    @Override
    public void makeMove(Move move) {

    }
}
