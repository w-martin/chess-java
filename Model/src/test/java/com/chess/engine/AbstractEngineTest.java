package com.chess.engine;

import com.chess.game.MoveController;
import com.chess.model.Board;
import com.chess.model.Move;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.mockito.Mockito.mock;

/**
 * Tests {@link com.chess.engine.AbstractEngine}.
 *
 * @author William Martin
 * @since v0.0
 */
public class AbstractEngineTest {

    private AbstractEngine engine;
    private MoveController moveController;

    @BeforeMethod
    public void setUp() throws Exception {
        moveController = mock(MoveController.class);
        engine = new EngineImpl(moveController);
    }

    /**
     * Tests the MoveController getter and setter.
     *
     * @throws Exception
     */
    @Test
    public void testMoveController() throws Exception {
        Assert.assertEquals(moveController, engine.getMoveController());
    }

    /**
     * Provides access to {@link com.chess.engine.AbstractEngine}.
     */
    private class EngineImpl extends AbstractEngine {

        public EngineImpl(MoveController moveController) {
            super(moveController);
        }

        @Override
        public Move move(Board board, Object side) {
            return null;
        }

        @Override
        public Assessment assess(Board board) {
            return null;
        }
    }
}
