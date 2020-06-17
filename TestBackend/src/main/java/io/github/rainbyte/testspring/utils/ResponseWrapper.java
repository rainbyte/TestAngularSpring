package io.github.rainbyte.testspring.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseWrapper<T> {
    public final T datum;
    public final String error;

    private ResponseWrapper(T datum, String error) {
        this.datum = datum;
        this.error = error;
    }

    public static <U> ResponseEntity<ResponseWrapper<U>> responseSuccess(U datum) {
        return new ResponseEntity<>(new ResponseWrapper<>(datum, null), HttpStatus.OK);
    }

    public static <U> ResponseEntity<ResponseWrapper<U>> responseFailure(String error) {
        return new ResponseEntity<>(new ResponseWrapper<>(null, error), HttpStatus.OK);
    }

    public static <U> ResponseEntity<ResponseWrapper<U>> responseInternalError(String error) {
        return new ResponseEntity<>(new ResponseWrapper<>(null, error), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
