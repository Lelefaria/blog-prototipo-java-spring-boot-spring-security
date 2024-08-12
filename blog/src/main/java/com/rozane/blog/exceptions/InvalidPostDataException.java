package com.rozane.blog.exceptions;

public class InvalidPostDataException extends RuntimeException {
    public InvalidPostDataException(String message) {
        super(message);
    }
}
