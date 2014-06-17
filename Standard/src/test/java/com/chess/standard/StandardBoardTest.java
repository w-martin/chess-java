package com.chess.standard;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests {@link com.chess.standard.StandardBoard}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardBoardTest {

    StandardBoard board;
    StandardPiece piece;
    StandardPosition position;

    @BeforeMethod
    public void setUp() throws Exception {
        board = StandardBoard.NewStandardBoard();
    }

    /**
     * Tests whether the method checkSquareOccupied works correctly.
     *
     * @throws Exception
     */
    @Test
    public void testCheckSquareOccupied() throws Exception {
        Assert.assertTrue(board.checkSquareOccupied(StandardPosition.fromCoord("A1")));
        Assert.assertTrue(board.checkSquareOccupied(StandardPosition.fromCoord("A2")));
        Assert.assertFalse(board.checkSquareOccupied(StandardPosition.fromCoord("A3")));

        piece = new StandardPiece(StandardTeam.WHITE, StandardType.PAWN);
        position = StandardPosition.fromCoord("A3");
        board.addPieceToPosition(position, piece);
        Assert.assertTrue(board.checkSquareOccupied(position));
    }
}
