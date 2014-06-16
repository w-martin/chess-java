package com.chess.standard;

import com.chess.model.Board;
import com.chess.model.Move;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Tests {@link com.chess.standard.StandardMoveController}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardMoveControllerTest {

    StandardMoveController moveController;

    @BeforeMethod
    public void setUp() throws Exception {
        moveController = new StandardMoveController(mock(StandardBoard.class));
    }

    /**
     * Tests whether the pawn moves forward one square correctly.
     *
     * @throws Exception
     */
    @Test
    public void testComputePawnMoveForward() throws Exception {
        StandardBoard board = StandardBoard.NewStandardBoard();
        List<Move> moves = moveController.computePawnMoveForward(
                board.getPieceAtPosition(
                        StandardPosition.positionFromCoord("B2")), board);
        Assert.assertEquals(1, moves.size());
        Assert.assertEquals(moves.get(0).getNewPosition(),
                StandardPosition.positionFromCoord("B3"));
    }
}
