package com.github.Maol.FireAlertAPI.Service;

import com.github.Maol.FireAlertAPI.Repository.ISafeZoneRepository;
import com.github.Maol.FireAlertAPI.Exception.SafeZoneNotFoundException;
import com.github.Maol.FireAlertAPI.Model.SafeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafeZoneService {
    @Autowired
    private ISafeZoneRepository safeZoneRepository;

    public List<SafeZone> findAll() {
        return safeZoneRepository.findAll();
    }

    public SafeZone add(SafeZone safeZone) {
        safeZoneRepository.save(safeZone);
        return safeZone;
    }

    public SafeZone findById(Long safeZoneId) {
        return safeZoneRepository.findById(safeZoneId).orElseThrow(() -> new SafeZoneNotFoundException(safeZoneId));
    }

    public Void delete(Long safeZoneId) {
        safeZoneRepository.deleteById(safeZoneId);
        return null;
    }

    public SafeZone update(SafeZone newsafezone, Long safeZoneId) {
        return safeZoneRepository.findById(safeZoneId).map(safeZone -> {
            safeZone.setLatitude(newsafezone.getLatitude());
            safeZone.setLongitude(newsafezone.getLongitude());
            return safeZoneRepository.save(safeZone);
        }).orElseThrow(() -> new SafeZoneNotFoundException(safeZoneId));
    }
}
