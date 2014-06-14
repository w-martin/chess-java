package com.chess.engine;

import com.chess.game.MoveController;
import com.chess.model.Board;
import com.chess.model.Move;
import com.chess.standard.StandardScorer;
import com.chess.standard.StandardTeam;

/**
 * Basic {@link com.chess.engine.Engine}
 */
public class BasicEngine extends NegamaxEngine {

    public BasicEngine(final MoveController moveController) {
        super(moveController, 1, new StandardScorer());
    }

    @Override
    public Move move(Board board, StandardTeam side) {
        return null;
    }
}
