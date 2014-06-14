package com.chess.integration.IT;

import com.chess.engine.BasicEngine;
import com.chess.game.GameController;
import com.chess.game.GameResult;
import com.chess.standard.StandardGameController;
import com.chess.standard.StandardTeam;
import org.junit.Assert;
import org.junit.Test;

/**
 * Integration test for basic chess engine.
 *
 * @author William Martin
 * @since v0.0
 */
public class IT {

    @Test
    public void testGame() throws Exception {
        final GameController controller = new StandardGameController(new BasicEngine(), new RandomEngine());
        final GameResult result = controller.playGame();
        Assert.assertTrue(result.getWinner() == StandardTeam.WHITE);
    }
}
