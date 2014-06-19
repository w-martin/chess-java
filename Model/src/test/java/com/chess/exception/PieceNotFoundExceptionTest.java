package com.chess.exception;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PieceNotFoundExceptionTest {

    @Test
    public void testDefaultConstructor() throws Exception {
        PieceNotFoundException exception = new PieceNotFoundException();
        Assert.assertNotNull(exception.getMessage());
        Assert.assertNotSame(exception.getMessage().length(), 0);
    }

    @Test
    public void testMessageConstructor() throws Exception {
        final String message = "this is a message";
        PieceNotFoundException exception = new PieceNotFoundException(message);
        Assert.assertNotNull(exception.getMessage());
        Assert.assertEquals(exception.getMessage(), message);
    }
}