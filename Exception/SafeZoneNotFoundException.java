package com.github.Maol.FireAlertAPI.Exception;

public class SafeZoneNotFoundException extends RuntimeException {
    public SafeZoneNotFoundException(Long safeZoneId) {
        super("Cannot find SafeZone " + safeZoneId);
    }
}
