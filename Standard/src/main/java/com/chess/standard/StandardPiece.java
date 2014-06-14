package com.chess.standard;

import com.chess.model.AbstractPiece;

/**
 * Represents a standard {@link com.chess.model.Piece}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardPiece extends AbstractPiece <StandardTeam, StandardType> {

    /**
     * Default constructor.
     *
     * @param team the team of this {@link com.chess.model.Piece}.
     * @param type the type of this {@link com.chess.model.Piece}.
     */
    public StandardPiece(final StandardTeam team, final StandardType type) {
        super(team, type);
    }
}
