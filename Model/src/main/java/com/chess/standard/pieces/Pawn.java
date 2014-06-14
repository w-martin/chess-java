package com.chess.standard.pieces;

import com.chess.model.AbstractPiece;
import com.chess.model.Board;
import com.chess.model.Position;

import java.util.List;
import java.util.Set;

/**
 * Represents a standard pawn.
 *
 * @author William Martin
 * @since 0.0
 */
public class Pawn extends AbstractPiece {

    public Pawn(final int side) {
        super(side);
    }

    @Override
    public Set<Position> computePossibleMoves(Position position, Board board) {
        return null;
    }

    @Override
    public List<Integer> getOpposingTeams() {
        return null;
    }
}
