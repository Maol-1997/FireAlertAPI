package com.github.Maol.FireAlertAPI.service;

import com.github.Maol.FireAlertAPI.Repository.IDangerZoneRepository;
import com.github.Maol.FireAlertAPI.exceptions.DangerZoneNotFoundException;
import com.github.Maol.FireAlertAPI.model.DangerZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangerZoneService {

    @Autowired
    private IDangerZoneRepository dangerZoneRepository;

    public List<DangerZone> findAll() {
        return dangerZoneRepository.findAll();
    }

    public DangerZone add(DangerZone dangerZone) {
        dangerZoneRepository.save(dangerZone);
        return dangerZone;
    }

    public DangerZone findById(Long dangerZoneId) {
        return dangerZoneRepository.findById(dangerZoneId).orElseThrow(() -> new DangerZoneNotFoundException(dangerZoneId));
    }

    public Void delete(Long dangerZoneId) {
        dangerZoneRepository.deleteById(dangerZoneId);
        return null;
    }

    public DangerZone update(DangerZone newdangerzone, Long dangerZoneId) {
        return dangerZoneRepository.findById(dangerZoneId).map(dangerZone -> {
            dangerZone.setLatitude(newdangerzone.getLatitude());
            dangerZone.setLongitude(newdangerzone.getLongitude());
            return dangerZoneRepository.save(dangerZone);
        }).orElseThrow(() -> new DangerZoneNotFoundException(dangerZoneId));
    }
}
