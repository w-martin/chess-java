package com.chess.standard;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Tests {@link com.chess.standard.StandardPosition}.
 *
 * @author William Martin
 * @since v0.0
 */
public class StandardPositionTest {

    StandardPosition position;

    @BeforeMethod
    public void setUp() throws Exception {
        position = new StandardPosition(1, 1);
    }

    /**
     * Tests the hash code to and from methods.
     *
     * @throws Exception
     */
    @Test
    public void testHashCode() throws Exception {
        int hashcode = position.hashCode();
        StandardPosition after = StandardPosition.positionFromHash(hashcode);
        Assert.assertEquals(hashcode, after.hashCode());
        Assert.assertEquals(after, position);
    }

    @Test
    public void testEquals() throws Exception {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (1 == i && 1 == j) {
                    Assert.assertEquals(position, new StandardPosition(i, j));
                } else {
                    Assert.assertNotEquals(position, new StandardPosition(i, j));
                }
            }
        }
    }

    @Test
    public void testPositionFromCoord() throws Exception {
        Assert.assertEquals(position, StandardPosition.positionFromCoord("A1"));
        Assert.assertNotEquals(position, StandardPosition.positionFromCoord("A2"));
        Assert.assertNotEquals(position, StandardPosition.positionFromCoord("B1"));
    }
}
