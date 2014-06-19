package com.chess.exception;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PositionTakenExceptionTest {

    @Test
    public void testDefaultConstructor() throws Exception {
        PositionTakenException exception = new PositionTakenException();
        Assert.assertNotNull(exception.getMessage());
        Assert.assertNotSame(exception.getMessage().length(), 0);
    }

    @Test
    public void testMessageConstructor() throws Exception {
        final String message = "this is a message";
        PositionTakenException exception = new PositionTakenException(message);
        Assert.assertNotNull(exception.getMessage());
        Assert.assertEquals(exception.getMessage(), message);
    }

}