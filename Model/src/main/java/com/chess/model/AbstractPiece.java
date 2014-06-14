package com.chess.model;

/**
 * Abstract {@link Piece} with an allegiance.
 *
 * @param <T> team enum.
 * @param <Y> type enum.
 *
 * @author William Martin
 * @since v0.0
 */
public abstract class AbstractPiece <T, Y> implements Piece <T, Y> {

    private boolean hasMoved;
    private final T team;
    private final Y type;

    /**
     * Default constructor.
     *
     * @param team the team of this {@link Piece}.
     */
    public AbstractPiece(final T team, final Y type) {
        this.hasMoved = false;
        this.team = team;
        this.type = type;
    }

    @Override
    public boolean checkHasMoved() {
        return hasMoved;
    }

    @Override
    public T getTeam() {
        return team;
    }

    @Override
    public Y getType() {
        return type;
    }
}
