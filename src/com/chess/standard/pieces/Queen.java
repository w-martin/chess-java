package com.chess.standard.pieces;

/**
 * Represents a Queen standard Piece.
 *
 * @author William Martin
 * @since v0.0
 */

import com.chess.model.AbstractPiece;
import com.chess.model.Board;
import com.chess.model.Piece;
import com.chess.model.Position;
import com.chess.standard.StandardPosition;

import java.util.HashSet;
import java.util.Set;

public class Queen extends AbstractPiece {

    /**
     * Default constructor.
     *
     * @param side the team of this Queen.
     */
    public Queen(final int side) {
        super(side);
    }

    @Override
    public Set<Position> computePossibleMoves(Position position, Board board) {
        /*
        Algorithm description: moves outward diagonally in 4 directions and
        adds squares to the set of possible moves. Stops when it hits something
        such as the edge of the Board or another Piece (which is added as a
        move).
         */
        Set<Position> positions = new HashSet<Position>();
        int x, y;
        Position p;
        for (int i = -1; i <= 1; i+=2) {
            x = position.getX();
            y = position.getY();
            do {
                x += i;
                p = new StandardPosition(x, y);
            } while (addValidMoveToSet(p, board, positions));
            x = position.getX();
            do {
                y += i;
                p = new StandardPosition(x, y);
            } while (addValidMoveToSet(p, board, positions));
        }
        for (int i = -1; i <= 1; i+=2) {
            for (int j = -1; j <= 1; j+=2) {
                x = position.getX();
                y = position.getY();
                do {
                    x += i;
                    y += j;
                    p = new StandardPosition(x, y);
                } while (addValidMoveToSet(p, board, positions));
            }
        }
        return positions;
    }

    /**
     * Checks if the given {@link Position} is valid and adds it to the set
     * if it is.
     *
     * @param position the Position to check for validity.
     * @param board the {@link Board} to check validity on.
     * @param positions the Set of Positions to add the new Position to, if
     *                  valid.
     * @return true if the algorithm should continue searching for positions
     * on this diagonal, false otherwise.
     */
    private boolean addValidMoveToSet(final Position position,
                                      final Board board,
                                      final Set<Position> positions) {
        boolean shouldContinue = false;
        try {
            Piece p = board.getPieceAtPosition(position);
            if (null == p) {
                shouldContinue = true;
                positions.add(position);
            } else if (p.getTeam() != this.getTeam()) {
                positions.add(position);
            }
        } catch (final IndexOutOfBoundsException e) {
        }
        return shouldContinue;
    }
}
