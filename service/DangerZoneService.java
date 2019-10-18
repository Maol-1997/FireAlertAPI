package com.github.Maol.FireAlertAPI.service;

import com.github.Maol.FireAlertAPI.Repository.IDangerZoneRepository;
import com.github.Maol.FireAlertAPI.exceptions.DangerZoneNotFoundException;
import com.github.Maol.FireAlertAPI.model.DangerZone;
import com.github.Maol.FireAlertAPI.model.UserLocation;
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

    public DangerZone check(UserLocation userloc){
        List<DangerZone> dangerZones = findAll();
        for(DangerZone dan : dangerZones){
            if(userloc.isNear(dan,dan.dangerZoneDistance()))
                return dan;//"Beware! There is a wildfire in your proximity at an approximate distance of "+ dan.getDistance();
        }
        return null;
    }
}
