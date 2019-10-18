package com.github.Maol.FireAlertAPI.Exception;

public class EmergencyNumberNotFoundException extends RuntimeException {
    public EmergencyNumberNotFoundException(Long emergencyNumberId) {
        super("Cannot find Emergency number " + emergencyNumberId);
    }
}
