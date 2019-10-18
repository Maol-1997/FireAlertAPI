package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.UserLocation;
import com.github.Maol.FireAlertAPI.Service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userlocation")
public class UserLocationController {
    @Autowired
    private UserLocationService userLocationService;

    @GetMapping("/")
    public ResponseEntity<List<UserLocation>> findAll() {
        return new ResponseEntity<List<UserLocation>>(userLocationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<UserLocation> FindById(@PathVariable Long userLocationId) {
        return new ResponseEntity<UserLocation>(userLocationService.findById(userLocationId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserLocation> add(@RequestBody UserLocation userLocationDTO) {
        UserLocation userLocation = new UserLocation();
        userLocation.setLongitude(userLocationDTO.getLongitude());
        userLocation.setLatitude(userLocationDTO.getLatitude());
        return new ResponseEntity<UserLocation>(userLocationService.add(userLocation),HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> delete(@PathVariable Long userLocationId) {
        return new ResponseEntity<Void>(userLocationService.delete(userLocationId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("{locationId}")
    public ResponseEntity<UserLocation> update(@RequestBody UserLocation userLocationDTO, @PathVariable Long userLocationId) {
        UserLocation userLocation = new UserLocation();
        userLocation.setLatitude(userLocationDTO.getLatitude());
        userLocation.setLongitude(userLocationDTO.getLongitude());
        return new ResponseEntity<UserLocation>(userLocationService.update(userLocation, userLocationId), HttpStatus.OK);
    }
}
