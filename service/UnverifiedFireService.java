package com.github.Maol.FireAlertAPI.Service;

import com.github.Maol.FireAlertAPI.Repository.IUnverifiedFireRepository;
import com.github.Maol.FireAlertAPI.Exception.UnverifiedFireNotFoundException;
import com.github.Maol.FireAlertAPI.Model.UnverifiedFire;
import com.github.Maol.FireAlertAPI.Model.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnverifiedFireService {
    @Autowired
    private IUnverifiedFireRepository unverifiedFireRepository;

    public List<UnverifiedFire> findAll() {
        return unverifiedFireRepository.findAll();
    }

    public UnverifiedFire add(UnverifiedFire unverifiedFire) {
        unverifiedFireRepository.save(unverifiedFire);
        return unverifiedFire;
    }

    public UnverifiedFire findById(Long unverifiedFireId) {
        return unverifiedFireRepository.findById(unverifiedFireId).orElseThrow(() -> new UnverifiedFireNotFoundException(unverifiedFireId));
    }

    public Void delete(Long unverifiedFireId) {
        unverifiedFireRepository.deleteById(unverifiedFireId);
        return null;
    }

    public UnverifiedFire update(UnverifiedFire newunverifiedfire, Long unverifiedFireId) {
        return unverifiedFireRepository.findById(unverifiedFireId).map(unverifiedFire -> {
            unverifiedFire.setReports(newunverifiedfire.getReports());
            unverifiedFire.setLatitude(newunverifiedfire.getLatitude());
            unverifiedFire.setLongitude(newunverifiedfire.getLongitude());
            return unverifiedFireRepository.save(unverifiedFire);
        }).orElseThrow(() -> new UnverifiedFireNotFoundException(unverifiedFireId));
    }

    public UnverifiedFire check(UserLocation userloc){
        List<UnverifiedFire> unverifiedFires = findAll();
        for(UnverifiedFire uf : unverifiedFires){
            if(userloc.isNear(uf,uf.getDistance()))
                return uf;
        }
        return null;
    }
}
