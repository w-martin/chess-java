package com.chess.game;

import com.chess.model.Board;
import com.chess.model.Move;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Tests {@link com.chess.game.AbstractMoveController}.
 *
 * @author William Martin
 * @since v0.0
 */
public class AbstractMoveControllerTest {

    private Board testBoard;
    private AbstractMoveController moveController;

    @BeforeMethod
    public void setUp() throws Exception {
        testBoard = mock(Board.class);
        moveController = new MoveControllerImpl(testBoard);
    }

    /**
     * Tests the Board getter and setter.
     *
     * @throws Exception
     */
    @Test
    public void testBoard() throws Exception {
        Assert.assertEquals(testBoard, moveController.getBoard());
    }

    /**
     * Provides access to {@link com.chess.game.AbstractMoveController}.
     */
    private class MoveControllerImpl <T, Y> extends AbstractMoveController {

        public MoveControllerImpl(Board board) {
            super(board);
        }

        @Override
        public boolean isInCheck(Board board, Object team) {
            return false;
        }

        @Override
        public void makeMove(Move move) {

        }
    }
}
