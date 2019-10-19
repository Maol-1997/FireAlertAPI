package com.github.Maol.FireAlertAPI.Service;

import com.github.Maol.FireAlertAPI.Exception.PlaceNotFoundException;
import com.github.Maol.FireAlertAPI.Model.Place;
import com.github.Maol.FireAlertAPI.Model.User;
import com.github.Maol.FireAlertAPI.Repository.IPlaceRepository;
import com.github.Maol.FireAlertAPI.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private IPlaceRepository placeRepository;

    @Autowired
    private IUserRepository userRepository;

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Place add(Place place) {
        placeRepository.save(place);
        return place;
    }

    public Place findById(Long placeId) {
        return placeRepository.findById(placeId).orElseThrow(() -> new PlaceNotFoundException(placeId));
    }

    public Void delete(Long placeId) {
        placeRepository.deleteById(placeId);
        return null;
    }

    public Place update(Place newplace, Long placeid) {
        return placeRepository.findById(placeid).map(place -> {
            place.setLatitude(newplace.getLatitude());
            place.setLongitude(newplace.getLongitude());
            return placeRepository.save(place);
        }).orElseThrow(() -> new PlaceNotFoundException(placeid));
    }

    public Place addPlace(Place place, User user) {

        user.getPlaces().add(place);
        userRepository.save(user);
        return place;
    }
}
