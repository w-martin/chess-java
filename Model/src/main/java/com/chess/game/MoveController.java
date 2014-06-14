package com.chess.game;

import com.chess.model.Board;
import com.chess.model.Move;

import java.util.Collection;
import java.util.List;

/**
 * Interface for a controller of chess moves.
 *
 * @author William Martin
 * @since v0.0
 */
public interface MoveController {

    /**
     * Computes the possible moves for the given team.
     *
     * @param board the {@link com.chess.model.Board} to compute moves on.
     * @param side the team to compute moves for.
     * @return the possible moves for the given team.
     */
    public Collection<Move> computeMoves(Board board, int side);

    /**
     * Gets the list of completed moves.
     *
     * @return the list of completed moves.
     */
    public List<Move> getMoveHistory();

    /**
     * Makes the given {@link com.chess.model.Move} and adds it to history.
     *
     * @param move the Move to make.
     */
    public void makeMove(Move move);
}
