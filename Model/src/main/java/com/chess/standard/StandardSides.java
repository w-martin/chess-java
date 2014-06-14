package com.chess.standard;

/**
 * Created by william on 13/06/14.
 */
public enum StandardSides {
    WHITE(1), BLACK(-1);

    private final int value;

    private StandardSides(final int value){
        this.value = value;
    }

    public int value() {
        return value;
    }
}
