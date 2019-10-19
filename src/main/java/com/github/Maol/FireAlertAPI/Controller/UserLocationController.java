package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.User;
import com.github.Maol.FireAlertAPI.Model.UserLocation;
import com.github.Maol.FireAlertAPI.Service.UserLocationService;
import com.github.Maol.FireAlertAPI.Service.UserService;
import io.jsonwebtoken.Claims;
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

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserLocation>> findAll() {
        return new ResponseEntity<List<UserLocation>>(userLocationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<UserLocation> FindById(@PathVariable Long userLocationId) {
        return new ResponseEntity<UserLocation>(userLocationService.findById(userLocationId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserLocation> add(@RequestBody UserLocation userLocationDTO,@RequestAttribute("claims") final Claims claims) {
        User user = userService.findByNum(claims.getSubject());
        user.getLocation().setLatitude(userLocationDTO.getLatitude());
        user.getLocation().setLongitude(userLocationDTO.getLongitude());
        userLocationService.update(user.getLocation(), user.getLocation().getId());
        return new ResponseEntity<UserLocation>(userLocationService.add(user.getLocation()),HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> delete(@PathVariable Long userLocationId) {
        return new ResponseEntity<Void>(userLocationService.delete(userLocationId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    public ResponseEntity<UserLocation> update(@RequestBody UserLocation userLocationDTO,@RequestAttribute("claims") final Claims claims) {
        User user = userService.findByNum(claims.getSubject());
        user.getLocation().setLatitude(userLocationDTO.getLatitude());
        user.getLocation().setLongitude(userLocationDTO.getLongitude());
        userLocationService.update(user.getLocation(), user.getLocation().getId());
        return new ResponseEntity<UserLocation>(userLocationService.update(user.getLocation(), user.getLocation().getId()), HttpStatus.OK);
    }
}
