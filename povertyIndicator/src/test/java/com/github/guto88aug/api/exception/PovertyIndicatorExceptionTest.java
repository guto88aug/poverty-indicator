package com.github.guto88aug.api.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PovertyIndicatorExceptionTest {

    @Test
    void testException(){
        PovertyIndicatorException suit = new PovertyIndicatorException("teste", HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals("teste", suit.getMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, suit.getHttpStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), suit.getStatus());

    }

}
