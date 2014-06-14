package com.chess.integration.IT;

import com.chess.game.GameController;
import com.chess.game.GameResult;
import com.chess.standard.StandardGameController;
import com.chess.standard.StandardSides;
import org.junit.Assert;
import org.junit.Test;

/**
 * Integration test for basic chess engine.
 */
public class IT {

    @Test
    public void testGame() throws Exception {
        final GameController controller = new StandardGameController(new BasicEngine(), new RandomEngine());
        final GameResult result = controller.playGame();
        Assert.assertTrue(result.getWinner() == StandardSides.WHITE.value());
    }

}
