package com.example.demo.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler.
 */
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(GitHubException.class)
    ResponseEntity<Object> handleGitHubException(RuntimeException ex, WebRequest request) {
        final String defaultMessage = "Internal Server Error";
        return handleExceptionInternal(
                ex,
                StringUtils.isNotBlank(ex.getMessage()) ? ex.getMessage() : defaultMessage,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }
}
