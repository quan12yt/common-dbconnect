package com.quan12yt.demo.exception;

public class CreateHikariDataSourceFailedException extends RuntimeException{

    public CreateHikariDataSourceFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateHikariDataSourceFailedException(String message) {
        super(message);
    }
}
