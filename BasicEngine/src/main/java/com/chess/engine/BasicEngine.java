package com.chess.engine;

import com.chess.game.MoveComputer;
import com.chess.game.MoveController;
import com.chess.model.Move;
import com.chess.standard.StandardBoard;
import com.chess.standard.StandardScorer;
import com.chess.standard.StandardTeam;

/**
 * Basic {@link com.chess.engine.Engine}
 */
public class BasicEngine extends NegamaxEngine {

    public BasicEngine(final MoveController moveController,
                       final MoveComputer moveComputer) {
        super(moveController, moveComputer, 1, new StandardScorer());
    }

    @Override
    public Move move(StandardBoard board, StandardTeam side) {
        return null;
    }
}
