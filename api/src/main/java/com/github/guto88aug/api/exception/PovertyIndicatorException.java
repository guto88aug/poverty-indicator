package com.github.guto88aug.api.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PovertyIndicatorException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;
    private final int status;

    public PovertyIndicatorException(String message, HttpStatus httpStatus) {

        this.httpStatus = httpStatus;
        this.message = message;
        this.status = httpStatus.value();
    }


}
