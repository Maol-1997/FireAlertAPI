package com.github.Maol.FireAlertAPI.Service;

import com.github.Maol.FireAlertAPI.Repository.IUserLocationRepository;
import com.github.Maol.FireAlertAPI.Exception.UserLocationNotFoundException;
import com.github.Maol.FireAlertAPI.Model.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLocationService {
    @Autowired
    private IUserLocationRepository userLocationRepository;

    public List<UserLocation> findAll() {
        return userLocationRepository.findAll();
    }

    public UserLocation add(UserLocation userLocation) {
        userLocationRepository.save(userLocation);
        return userLocation;
    }

    public UserLocation findById(Long userLocationId) {
        return userLocationRepository.findById(userLocationId).orElseThrow(() -> new UserLocationNotFoundException(userLocationId));
    }

    public Void delete(Long userLocationId) {
        userLocationRepository.deleteById(userLocationId);
        return null;
    }

    public UserLocation update(UserLocation newuserlocation, Long userlocationid) {
        return userLocationRepository.findById(userlocationid).map(userLocation -> {
            userLocation.setLatitude(newuserlocation.getLatitude());
            userLocation.setLongitude(newuserlocation.getLongitude());
            return userLocationRepository.save(userLocation);
        }).orElseThrow(() -> new UserLocationNotFoundException(userlocationid));
    }
}
