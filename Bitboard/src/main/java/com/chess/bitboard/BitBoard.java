package com.chess.bitboard;

import com.chess.model.AbstractBoard;
import com.chess.model.Board;
import com.chess.model.Move;
import com.chess.model.Position;
import com.chess.standard.StandardPiece;
import com.chess.standard.StandardTeam;

import java.util.Set;

/**
 * Standard chess board represented by bitboard to allow for AND/OR computation
 * and efficient data transfer.
 *
 * @author William Martin
 * @since v0.0
 */
public class BitBoard extends AbstractBoard <StandardTeam, StandardPiece> {

    /**
     * Default constructor.
     */
    protected BitBoard() {
        super(8, 8);
    }

    @Override
    public Set<StandardPiece> getPieces() {
        return null;
    }

    @Override
    public Set<StandardPiece> getPieces(StandardTeam side) {
        return null;
    }

    @Override
    public StandardPiece getPieceAtPosition(Position position) {
        return null;
    }

    @Override
    public void removePieceAtPosition(Position position) {

    }

    @Override
    public void addPieceToPosition(Position position, StandardPiece piece) {

    }

    @Override
    public boolean checkPositionInBounds(Position position) {
        return false;
    }

    @Override
    public boolean checkSquareCoveredByTeam(Position position, StandardTeam team) {
        return false;
    }

    @Override
    public boolean checkSquareOccupiedByTeam(Position position, StandardTeam team) {
        return false;
    }

    @Override
    public boolean checkSquareOccupied(Position position) {
        return false;
    }

    @Override
    public int getNoPieces(StandardTeam side) {
        return 0;
    }

    @Override
    public Position getPosition(StandardPiece piece) {
        return null;
    }

    @Override
    public Board<StandardTeam, StandardPiece> getUpdatedBoard(Move move) {
        return null;
    }
}
