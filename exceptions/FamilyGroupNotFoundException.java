package com.github.Maol.FireAlertAPI.exceptions;

public class FamilyGroupNotFoundException extends RuntimeException {
    public FamilyGroupNotFoundException(Long familyGroupId) {
        super("Cannot find SafeZone " + familyGroupId);
    }
}
