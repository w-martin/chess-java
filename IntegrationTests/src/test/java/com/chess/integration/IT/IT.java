package com.chess.integration.IT;

import com.chess.engine.BasicEngine;
import com.chess.engine.RandomEngine;
import com.chess.game.GameController;
import com.chess.game.GameResult;
import com.chess.game.MoveController;
import com.chess.standard.StandardGameController;
import com.chess.standard.StandardTeam;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * Integration test for basic chess engine.
 *
 * @author William Martin
 * @since v0.0
 */
public class IT {

    private MoveController moveController;

    @BeforeMethod
    public void setUp() throws Exception {
        moveController = mock(MoveController.class);
    }

    @Test
    public void testGame() throws Exception {
        final GameController controller = new StandardGameController(
                new BasicEngine(moveController), new RandomEngine(moveController));
        final GameResult result = controller.playGame();
        Assert.assertTrue(result.getWinner() == StandardTeam.WHITE);
    }
}
