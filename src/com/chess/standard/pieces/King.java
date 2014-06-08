package com.chess.standard.pieces;

/**
 * Represents a King standard Piece.
 *
 * @author William Martin
 * @since v0.0
 */

import com.chess.model.AbstractPiece;
import com.chess.model.Board;
import com.chess.model.Position;
import com.chess.standard.StandardPosition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class King extends AbstractPiece {

    /**
     * Default constructor.
     *
     * @param side the team of this King.
     */
    public King(final int side) {
        super(side);
    }

    @Override
    public Set<Position> computePossibleMoves(final Position position,
                                              final Board board) {
        /*
        Algorithm description: moves outward diagonally in 4 directions and
        adds squares to the set of possible moves. Stops when it hits something
        such as the edge of the Board or another Piece (which is added as a
        move).
         */
        Set<Position> positions = new HashSet<Position>();
        int x = position.getX();
        int y = position.getY();
        for (int j = -1; j <= 1; j++) {
            for (int i = -1; i <= 1; i++) {
                if (!(0 == i && 0 ==j)) {
                    addValidMoveToSet(new StandardPosition(x + i, y + j),
                            board, positions);
                }
            }
        }
        if (!this.checkHasMoved()) {
            addCastleMoves(position, board, positions);
        }
        return positions;
    }

    /**
     * Adds the potential castle moves to the move sets.
     *
     * @param position the Position of this piece.
     * @param board the {@link Board} to check validity on..
     * @param positions the Set of Positions to add the new Position to, if
     *                  valid.
     */
    private void addCastleMoves(final Position position,
                                final Board board,
                                final Set<Position> positions) {
        int x = position.getX();
        int y = position.getY();
        // left
        for (int i = -3; i <= -1; i++) {
            if (!board.checkSquareOccupied(new StandardPosition(x + i, y))) {
                break;
            }
        }
        // right
        for (int i = 1; i <= 2; i++) {
            if (!board.checkSquareOccupied(new StandardPosition(x + i, y))) {
                break;
            }
        }
    }

    @Override
    public List<Integer> getOpposingTeams() {
        List<Integer> teams = new ArrayList<Integer>(1);
        teams.add((0 == this.getTeam()) ? 1 : 0);
        return teams;
    }

    /**
     * Checks if the given {@link Position} is valid and adds it to the set
     * if it is.
     *
     * @param position the Position to check for validity.
     * @param board the {@link Board} to check validity on.
     * @param positions the Set of Positions to add the new Position to, if
     *                  valid.
     */
    private boolean addValidMoveToSet(final Position position,
                                      final Board board,
                                      final Set<Position> positions) {
        boolean shouldContinue = false;
        if (board.checkPositionInBounds(position)
                && !board.checkSquareOccupiedByTeam(position, this.getTeam())
                && !board.checkSquareCoveredByTeam(position,
                this.getOpposingTeams().get(0))) {
            positions.add(position);
        }
    }
}
