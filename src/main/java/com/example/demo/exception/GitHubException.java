package com.example.demo.exception;

public class GitHubException extends RuntimeException {

    public GitHubException(String message) {
        super(message);
    }
}