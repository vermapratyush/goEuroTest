package com.goeuro.interview.exception;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Wrapper Exception for all type of mapping exception.
 * This could be related to CSV/JSON.
 * Nested exception will give detail about the exact reason.
 */
public class ObjectMapperException extends JsonProcessingException {
    public ObjectMapperException(String msg, JsonLocation loc, Throwable rootCause) {
        super(msg, loc, rootCause);
    }

    public ObjectMapperException(String msg) {
        super(msg);
    }

    public ObjectMapperException(String msg, JsonLocation loc) {
        super(msg, loc);
    }

    public ObjectMapperException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }

    public ObjectMapperException(Throwable rootCause) {
        super(rootCause);
    }
}
