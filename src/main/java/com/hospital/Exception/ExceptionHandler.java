package com.hospital.Exception;

public class ExceptionHandler extends RuntimeException {

    public ExceptionHandler(Integer id) {
        super("Could not find " + id);
    }
}
