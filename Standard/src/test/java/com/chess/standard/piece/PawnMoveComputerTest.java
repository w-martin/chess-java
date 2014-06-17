package com.chess.standard.piece;

import com.chess.model.Move;
import com.chess.model.Position;
import com.chess.standard.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Tests {@link com.chess.standard.StandardMoveController}.
 *
 * @author William Martin
 * @since v0.0
 */
public class PawnMoveComputerTest {

    PawnMoveComputer moveComputer;
    StandardBoard board;
    List<Move> moves;
    StandardPiece piece;
    StandardPosition position;

    @BeforeMethod
    public void setUp() throws Exception {
        moveComputer = new PawnMoveComputer();
        board = StandardBoard.NewStandardBoard();
    }

    /**
     * Tests whether the pawn moves forward one square correctly under
     * normal conditions.
     */
    @Test
    public void testComputePawnMoveForward() throws Exception {
        piece = board.getPieceAtPosition(
                StandardPosition.fromCoord("B2"));
        moves = moveComputer.computePawnMoveForward(board, piece);
        Assert.assertEquals(1, moves.size());
        Assert.assertEquals(moves.get(0).getNewPosition(),
                StandardPosition.fromCoord("B3"));
        Assert.assertNull(moves.get(0).getUpgradedPiece());
        Assert.assertEquals(moves.get(0).getPiece(), piece);

        piece = board.getPieceAtPosition(
                StandardPosition.fromCoord("B7"));
        moves = moveComputer.computePawnMoveForward(board, piece);
        Assert.assertEquals(1, moves.size());
        Assert.assertEquals(moves.get(0).getNewPosition(),
                StandardPosition.fromCoord("B6"));
        Assert.assertNull(moves.get(0).getUpgradedPiece());
        Assert.assertEquals(moves.get(0).getPiece(), piece);
    }

    /**
     * Tests whether the pawn moves forward one square correctly when blocked.
     */
    @Test
    public void testComputePawnMoveForwardBlocked() throws Exception {
        board.addPieceToPosition(StandardPosition.fromCoord("B3"),
                mock(StandardPiece.class));
        piece = board.getPieceAtPosition(StandardPosition.fromCoord("B2"));
        moves = moveComputer.computePawnMoveForward(board, piece);
        Assert.assertEquals(moves.size(), 0);

        board.addPieceToPosition(StandardPosition.fromCoord("B6"),
                mock(StandardPiece.class));
        piece = board.getPieceAtPosition(StandardPosition.fromCoord("B7"));
        moves = moveComputer.computePawnMoveForward(board, piece);
        Assert.assertEquals(0, moves.size());
    }

    /**
     * Tests whether the pawn moves forward one square correctly when upgrading.
     */
    @Test
    public void testComputePawnMoveForwardUpgrade() throws Exception {
        board = new StandardBoard();

        piece = new StandardPiece(StandardTeam.WHITE, StandardType.PAWN);
        board.addPieceToPosition(StandardPosition.fromCoord("A7"), piece);
        moves = moveComputer.computePawnMoveForward(board, piece);
        Assert.assertEquals(4, moves.size());
        position = StandardPosition.fromCoord("A8");
        testMove_testComputePawnMoveForwardUpgrade(moves.get(0), position,
                StandardTeam.WHITE, StandardType.BISHOP);
        testMove_testComputePawnMoveForwardUpgrade(moves.get(1), position,
                StandardTeam.WHITE, StandardType.KNIGHT);
        testMove_testComputePawnMoveForwardUpgrade(moves.get(2), position,
                StandardTeam.WHITE, StandardType.ROOK);
        testMove_testComputePawnMoveForwardUpgrade(moves.get(3), position,
                StandardTeam.WHITE, StandardType.QUEEN);

        piece = new StandardPiece(StandardTeam.BLACK, StandardType.PAWN);
        board.addPieceToPosition(StandardPosition.fromCoord("A2"), piece);
        moves = moveComputer.computePawnMoveForward(board, piece);
        Assert.assertEquals(4, moves.size());
        position = StandardPosition.fromCoord("A1");
        testMove_testComputePawnMoveForwardUpgrade(moves.get(0), position,
                StandardTeam.BLACK, StandardType.BISHOP);
        testMove_testComputePawnMoveForwardUpgrade(moves.get(1), position,
                StandardTeam.BLACK, StandardType.KNIGHT);
        testMove_testComputePawnMoveForwardUpgrade(moves.get(2), position,
                StandardTeam.BLACK, StandardType.ROOK);
        testMove_testComputePawnMoveForwardUpgrade(moves.get(3), position,
                StandardTeam.BLACK, StandardType.QUEEN);
    }

    /**
     * Tests a batch of conditions for a pawn upgrade move.
     */
    private void testMove_testComputePawnMoveForwardUpgrade(
            final Move move, final Position position, final StandardTeam team,
            final StandardType type) {
        Assert.assertEquals(move.getNewPosition(), position);
        Assert.assertEquals(move.getUpgradedPiece().getTeam(), team);
        Assert.assertEquals(move.getUpgradedPiece().getType(), type);
    }
}
