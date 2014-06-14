package com.chess.standard;

import com.chess.model.*;

import java.util.*;

/**
 * Standard 8x8 chess {@link com.chess.model.Board}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardBoard extends AbstractBoard {

    final Map<Integer, Piece> pieceMap;
    final Set<Piece> whitePieces;
    final Set<Piece> blackPieces;

    /**
     * Default constructor.
     */
    public StandardBoard() {
        super(8, 8);
        pieceMap = new HashMap<Integer, Piece>(32);
        whitePieces = new HashSet<Piece>(16);
        blackPieces = new HashSet<Piece>(16);
    }

    @Override
    public Set<Piece> getPieces() {
        return new HashSet<Piece>(pieceMap.values());
    }

    @Override
    public Set<Piece> getPieces(final int side) {
        return (StandardSides.WHITE.value() == side) ? whitePieces : blackPieces;
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
    public boolean checkSquareCoveredByTeam(final Position position, final int team) {
        return false;
    }

    @Override
    public boolean checkSquareOccupiedByTeam(final Position position, final int team) {
        return false;
    }

    @Override
    public boolean checkSquareOccupied(final Position position) {
        return false;
    }

    @Override
    public int getNoPieces(final int side) {
        return getPieces(side).size();
    }

    @Override
    public List<Move> getPossibleMoves(final int side) {
        final List<Move> moves = new ArrayList<Move>();
        final Set<Piece> pieces = getPieces(side);
        for (final Piece p : pieces) {
            moves.addAll(((AbstractPiece) p).computePossibleMoves());
        }
        return moves;
    }
}
