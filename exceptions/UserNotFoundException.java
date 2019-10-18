package com.github.Maol.FireAlertAPI.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("Cannot find User " + userId);
    }
}
