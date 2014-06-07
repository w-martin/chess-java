package com.chess.standard;

import com.chess.model.AbstractBoard;
import com.chess.model.Piece;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Standard 8x8 chess {@link com.chess.model.Board}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardBoard extends AbstractBoard {

    /**
     * Default constructor.
     */
    public StandardBoard() {
        super(8, 8);
    }

    @Override
    public List<Piece> getPieces() {
        throw new NotImplementedException();
    }
}
