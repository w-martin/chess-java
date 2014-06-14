package com.chess.standard;

import com.chess.model.*;

import java.util.*;

/**
 * Standard 8x8 chess {@link com.chess.model.Board}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardBoard extends AbstractBoard <StandardTeam, StandardType> {

    final Map<Integer, Piece<StandardTeam, StandardType>> pieceMap;
    final Set<Piece<StandardTeam, StandardType>> whitePieces;
    final Set<Piece<StandardTeam, StandardType>> blackPieces;

    /**
     * Default constructor.
     */
    public StandardBoard() {
        super(8, 8);
        pieceMap = new HashMap<Integer, Piece<StandardTeam, StandardType>>(32);
        whitePieces = new HashSet<Piece<StandardTeam, StandardType>>(16);
        blackPieces = new HashSet<Piece<StandardTeam, StandardType>>(16);
    }

    @Override
    public Set<Piece<StandardTeam, StandardType>> getPieces() {
        return new HashSet<Piece<StandardTeam, StandardType>>(
                pieceMap.values());
    }

    @Override
    public Set<Piece<StandardTeam, StandardType>> getPieces(
            final StandardTeam side) {
        return StandardTeam.WHITE == side ? whitePieces : blackPieces;
    }

    @Override
    public Piece getPieceAtPosition(final Position position)
            throws IndexOutOfBoundsException {
        // @TODO ensure comparison works by hash/x&y and not pointer
        if (1 > position.getX() || 8 < position.getX()
                || 1 > position.getY() || 8 < position.getY()) {
            throw new IndexOutOfBoundsException();
        }
        return pieceMap.get(position.hashCode());
    }

    @Override
    public void removePieceAtPosition(final Position position) {
        pieceMap.remove(position.hashCode());
    }

    @Override
    public void addPieceToPosition(final Position position,
                                   final Piece piece) {
        pieceMap.put(position.hashCode(), piece);
    }

    @Override
    public boolean checkPositionInBounds(final Position position) {
        return (0 < position.getX() &&
                this.getWidth() >= position.getX() &&
                0 < position.getY() &&
                this.getHeight() >= position.getY());
    }

    @Override
    public boolean checkSquareCoveredByTeam(final Position position, final StandardTeam team) {
        return false;
    }

    @Override
    public boolean checkSquareOccupiedByTeam(final Position position, final StandardTeam team) {
        return false;
    }

    @Override
    public boolean checkSquareOccupied(final Position position) {
        return false;
    }

    @Override
    public int getNoPieces(final StandardTeam side) {
        return getPieces(side).size();
    }
}
