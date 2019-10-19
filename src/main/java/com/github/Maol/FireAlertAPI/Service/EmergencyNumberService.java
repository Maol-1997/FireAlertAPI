package com.github.Maol.FireAlertAPI.Service;

import com.github.Maol.FireAlertAPI.Repository.IEmergencyNumberRepository;
import com.github.Maol.FireAlertAPI.Model.EmergencyNumber;
import com.github.Maol.FireAlertAPI.Exception.EmergencyNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyNumberService {
    @Autowired
    private IEmergencyNumberRepository emergencyNumberRepository;

    public List<EmergencyNumber> findAll() {
        return emergencyNumberRepository.findAll();
    }

    public EmergencyNumber add(EmergencyNumber emergencyNumber) {
        emergencyNumberRepository.save(emergencyNumber);
        return emergencyNumber;
    }

    public EmergencyNumber findById(Long emergencyNumberId) {
        return emergencyNumberRepository.findById(emergencyNumberId).orElseThrow(() -> new EmergencyNumberNotFoundException(emergencyNumberId));
    }

    public Void delete(Long emergencyNumberId) {
        emergencyNumberRepository.deleteById(emergencyNumberId);
        return null;
    }

    public EmergencyNumber update(EmergencyNumber newemergencynumber, Long emergencyNumberId) {
        return emergencyNumberRepository.findById(emergencyNumberId).map(emergencyNumber -> {
            emergencyNumber.setNumber(newemergencynumber.getNumber());
            emergencyNumber.setCountry(newemergencynumber.getCountry());
            return emergencyNumberRepository.save(emergencyNumber);
        }).orElseThrow(() -> new EmergencyNumberNotFoundException(emergencyNumberId));
    }
}
