package com.github.Maol.FireAlertAPI.Exception;

public class DangerZoneNotFoundException extends RuntimeException {
    public DangerZoneNotFoundException(Long dangerZoneId) {
        super("Cannot find Emergency DangerZone " + dangerZoneId);
    }
}
