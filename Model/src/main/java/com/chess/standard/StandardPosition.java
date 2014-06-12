package com.chess.standard;

import com.chess.model.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * Overrides hashCode method for standard 8x8 boards.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardPosition extends Position {

    private static Map<Character, Integer> letters = new HashMap<Character, Integer>(8);
    private static Map<Integer, Character> numbers = new HashMap<Integer, Character>(8);
    static {
        letters.put('A', 1);
        letters.put('B', 2);
        letters.put('C', 3);
        letters.put('D', 4);
        letters.put('E', 5);
        letters.put('F', 6);
        letters.put('G', 7);
        letters.put('H', 8);

        numbers.put(1, 'A');
        numbers.put(2, 'B');
        numbers.put(3, 'C');
        numbers.put(4, 'D');
        numbers.put(5, 'E');
        numbers.put(6, 'F');
        numbers.put(7, 'G');
        numbers.put(8, 'H');
    }

    public StandardPosition(final int x, final int y) {
        super(x, y);
    }

    @Override
    public int hashCode() {
        return (8 * (getY() - 1)) + getX() - 1;
    }

    public static StandardPosition positionFromCoord(final String coord) {
        // A5 means x=1, y=5 etc
        int x, y;
        x = letters.get(coord.charAt(0));
        y = Integer.parseInt(Character.toString(coord.charAt(1)));
        return new StandardPosition(x, y);
    }

    @Override
    public String toString() {
        return String.format("%s%d", numbers.get(this.getX()), this.getY());
    }
}
