package hu.joel.laczkovszki.qa.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final HttpStatus status;
    private final String message;
    private final ZonedDateTime timestamp;

    public ApiException(String message, HttpStatus status, ZonedDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
