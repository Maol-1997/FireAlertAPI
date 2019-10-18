package com.github.Maol.FireAlertAPI.exceptions;

public class DangerZoneNotFoundException extends RuntimeException {
    public DangerZoneNotFoundException(Long dangerZoneId) {
        super("Cannot find Emergency DangerZone " + dangerZoneId);
    }
}
