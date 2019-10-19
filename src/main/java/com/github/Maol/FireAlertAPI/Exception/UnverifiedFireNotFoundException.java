package com.github.Maol.FireAlertAPI.Exception;

public class UnverifiedFireNotFoundException extends RuntimeException {
    public UnverifiedFireNotFoundException(Long fireId) {
        super("Cannot find UnverifiedFire " + fireId);
    }
}
