package com.github.Maol.FireAlertAPI.exceptions;

public class EmergencyNumberNotFoundException extends RuntimeException {
    public EmergencyNumberNotFoundException(Long emergencyNumberId) {
        super("Cannot find Emergency number " + emergencyNumberId);
    }
}
