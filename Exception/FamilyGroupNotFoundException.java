package com.github.Maol.FireAlertAPI.Exception;

public class FamilyGroupNotFoundException extends RuntimeException {
    public FamilyGroupNotFoundException(Long familyGroupId) {
        super("Cannot find SafeZone " + familyGroupId);
    }
}
