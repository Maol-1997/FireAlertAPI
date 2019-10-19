package com.github.Maol.FireAlertAPI.Exception;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException(Long placeId) {
        super("Cannot find Place " + placeId);
    }
}
