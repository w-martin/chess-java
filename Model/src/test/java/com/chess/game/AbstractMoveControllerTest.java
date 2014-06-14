package com.chess.game;

import com.chess.model.Board;
import com.chess.model.Move;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
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

    @Before
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
    private class MoveControllerImpl extends AbstractMoveController {

        private MoveControllerImpl(final Board board) {
            super(board);
        }
        @Override
        public Collection<Move> computeMoves(Board board, int side) {
            return null;
        }

        @Override
        public List<Move> getMoveHistory() {
            return null;
        }

        @Override
        public void makeMove(Move move) {

        }
    }
}
