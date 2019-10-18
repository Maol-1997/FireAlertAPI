package com.github.Maol.FireAlertAPI.exceptions;

public class UserLocationNotFoundException extends RuntimeException {
    public UserLocationNotFoundException(Long userLocationId) {
        super("Cannot find UserLocation " + userLocationId);
    }
}
