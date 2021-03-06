package com.chess.standard;

import com.chess.exception.PieceNotFoundException;
import com.chess.exception.PositionTakenException;
import com.chess.model.*;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.*;

/**
 * Standard 8x8 chess {@link com.chess.model.Board}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardBoard extends AbstractBoard<StandardTeam,
        StandardType, StandardPiece> {

    final BiMap<Integer, StandardPiece> pieceMap;
    final Set<StandardPiece> whitePieces;
    final Set<StandardPiece> blackPieces;

    /**
     * Default constructor.
     */
    public StandardBoard() {
        super(8, 8);
        pieceMap = HashBiMap.create(32);
        whitePieces = new HashSet<>(16);
        blackPieces = new HashSet<>(16);
    }

    @Override
    public Set<StandardPiece> getPieces() {
        return new HashSet<>(pieceMap.values());
    }

    @Override
    public Set<StandardPiece> getPieces(
            final StandardTeam side) {
        return StandardTeam.WHITE == side ? whitePieces : blackPieces;
    }

    @Override
    public StandardPiece getPieceAtPosition(final Position position)
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
                                   final StandardPiece piece)
            throws PositionTakenException {

        if (null == getPieceAtPosition(position)) {
            pieceMap.put(position.hashCode(), piece);
            ((StandardTeam.WHITE == piece.getTeam()) ? whitePieces : blackPieces).
                    add(piece);
        } else {
            throw new PositionTakenException(
                    String.format("Error. Position at %s is taken.",
                            position.toString()));
        }
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
        return (null != getPieceAtPosition(position));
    }

    @Override
    public int getNoPieces(final StandardTeam side) {
        return getPieces(side).size();
    }

    @Override
    public int getNoPieces() {
        return pieceMap.size();
    }

    @Override
    public Position getPosition(final StandardPiece piece)
            throws PieceNotFoundException {
        Position result = StandardPosition.positionFromHash(
                pieceMap.inverse().get(piece));
        if (null != result) {
            return result;
        } else {
            throw new PieceNotFoundException(
                    String.format("No Piece on board: %s",
                            piece.toString()));
        }
    }

    @Override
    public Position getPosition(final StandardTeam pieceTeam,
                                final StandardType pieceType)
            throws PieceNotFoundException {
        for (final StandardPiece piece : getPieces(pieceTeam)) {
            if (pieceType == piece.getType()) {
                return getPosition(piece);
            }
        }
        throw new PieceNotFoundException(
                String.format("No Piece on board of team %s and type %s",
                        pieceTeam.toString(),
                        pieceType.toString()));
    }

    @Override
    public Board<StandardTeam, StandardType, StandardPiece> getUpdatedBoard(
            final Move move) {
        return null;
    }

    /**
     * Constructs a new standard chess board.
     *
     * @return a new standard chess board.
     */
    public static StandardBoard createStandardBoard() {
        StandardBoard board = new StandardBoard();
        try {
            board.addPieceToPosition(StandardPosition.fromCoord("A1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.ROOK));
            board.addPieceToPosition(StandardPosition.fromCoord("B1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.KNIGHT));
            board.addPieceToPosition(StandardPosition.fromCoord("C1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.BISHOP));
            board.addPieceToPosition(StandardPosition.fromCoord("D1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.QUEEN));
            board.addPieceToPosition(StandardPosition.fromCoord("E1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.KING));
            board.addPieceToPosition(StandardPosition.fromCoord("F1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.BISHOP));
            board.addPieceToPosition(StandardPosition.fromCoord("G1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.KNIGHT));
            board.addPieceToPosition(StandardPosition.fromCoord("H1"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.ROOK));
            board.addPieceToPosition(StandardPosition.fromCoord("A2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("B2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("C2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("D2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("E2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("F2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("G2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("H2"),
                    new StandardPiece(StandardTeam.WHITE, StandardType.PAWN));

            board.addPieceToPosition(StandardPosition.fromCoord("A8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.ROOK));
            board.addPieceToPosition(StandardPosition.fromCoord("B8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.KNIGHT));
            board.addPieceToPosition(StandardPosition.fromCoord("C8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.BISHOP));
            board.addPieceToPosition(StandardPosition.fromCoord("D8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.QUEEN));
            board.addPieceToPosition(StandardPosition.fromCoord("E8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.KING));
            board.addPieceToPosition(StandardPosition.fromCoord("F8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.BISHOP));
            board.addPieceToPosition(StandardPosition.fromCoord("G8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.KNIGHT));
            board.addPieceToPosition(StandardPosition.fromCoord("H8"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.ROOK));
            board.addPieceToPosition(StandardPosition.fromCoord("A7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("B7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("C7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("D7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("E7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("F7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("G7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
            board.addPieceToPosition(StandardPosition.fromCoord("H7"),
                    new StandardPiece(StandardTeam.BLACK, StandardType.PAWN));
        } catch (PositionTakenException e) {
            e.printStackTrace();
        }

        return board;
    }
}
