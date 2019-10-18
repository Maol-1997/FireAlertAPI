package com.github.Maol.FireAlertAPI.exceptions;

public class SafeZoneNotFoundException extends RuntimeException {
    public SafeZoneNotFoundException(Long safeZoneId) {
        super("Cannot find SafeZone " + safeZoneId);
    }
}
