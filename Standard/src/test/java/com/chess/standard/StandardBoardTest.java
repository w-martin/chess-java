package com.chess.standard;

import com.chess.exception.PositionTakenException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

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
        board = StandardBoard.createStandardBoard();
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

    @Test
    public void testGetPositionPiece() throws Exception {
        position = StandardPosition.fromCoord("A1");
        piece = board.getPieceAtPosition(position);
        Assert.assertEquals(board.getPosition(piece), position);
    }

    @Test
    public void testGetPositionTeamType() throws Exception {
        Assert.assertEquals(board.getPosition(StandardTeam.WHITE,
                StandardType.KING), StandardPosition.fromCoord("E1"));
        Assert.assertEquals(board.getPosition(StandardTeam.BLACK,
                StandardType.KING), StandardPosition.fromCoord("E8"));

        Assert.assertEquals(board.getPosition(StandardTeam.WHITE,
                StandardType.QUEEN), StandardPosition.fromCoord("D1"));
        Assert.assertEquals(board.getPosition(StandardTeam.BLACK,
                StandardType.QUEEN), StandardPosition.fromCoord("D8"));
    }

    @Test
    public void testCreateStandardBoard() throws Exception {
        Assert.assertEquals(board.getNoPieces(), 32);
        Assert.assertEquals(board.getNoPieces(StandardTeam.WHITE), 16);
        Assert.assertEquals(board.getNoPieces(StandardTeam.BLACK), 16);
    }

    @Test(expectedExceptions = PositionTakenException.class)
    public void testAddPieceToPositionException() throws Exception {
        board.addPieceToPosition(StandardPosition.fromCoord("A1"),
                mock(StandardPiece.class));
    }

    @Test
    public void testAddPieceToPosition() throws Exception {
        position = StandardPosition.fromCoord("C4");
        Assert.assertNull(board.getPieceAtPosition(position));
        piece = new StandardPiece(StandardTeam.WHITE, StandardType.QUEEN);
        int whitePieces = board.getNoPieces(StandardTeam.WHITE);
        int blackPieces = board.getNoPieces(StandardTeam.BLACK);
        int noPieces = board.getNoPieces();
        board.addPieceToPosition(position, piece);
        Assert.assertEquals(board.getPieceAtPosition(position), piece);
        Assert.assertEquals(board.getNoPieces(), noPieces + 1);
        Assert.assertEquals(board.getNoPieces(StandardTeam.WHITE), whitePieces + 1);
        Assert.assertEquals(board.getNoPieces(StandardTeam.BLACK), blackPieces);
        Assert.assertEquals(board.getPieceAtPosition(position), piece);

        position = StandardPosition.fromCoord("D4");
        Assert.assertNull(board.getPieceAtPosition(position));
        piece = new StandardPiece(StandardTeam.BLACK, StandardType.QUEEN);
        board.addPieceToPosition(position, piece);
        Assert.assertEquals(board.getPieceAtPosition(position), piece);
        Assert.assertEquals(board.getNoPieces(), noPieces + 2);
        Assert.assertEquals(board.getNoPieces(StandardTeam.WHITE), whitePieces + 1);
        Assert.assertEquals(board.getNoPieces(StandardTeam.BLACK), blackPieces + 1);
        Assert.assertEquals(board.getPieceAtPosition(position), piece);
    }
}
