package com.chess.standard;

import com.chess.model.AbstractBoard;
import com.chess.model.Piece;
import com.chess.model.Position;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Standard 8x8 chess {@link com.chess.model.Board}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardBoard extends AbstractBoard {

    final Map<Integer, Piece> pieceMap;

    /**
     * Default constructor.
     */
    public StandardBoard() {
        super(8, 8);
        pieceMap = new HashMap<Integer, Piece>(32);
    }

    @Override
    public Set<Piece> getPieces() {
        return new HashSet<Piece>(pieceMap.values());
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
}
