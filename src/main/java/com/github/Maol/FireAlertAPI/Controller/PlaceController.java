package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.Place;
import com.github.Maol.FireAlertAPI.Service.PlaceService;
import com.github.Maol.FireAlertAPI.Service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private UserService userService;


    @PostMapping("/place")
    public ResponseEntity<Place> addPlace(@RequestBody Place place, @RequestAttribute("claims") final Claims claims){
        return new ResponseEntity<Place>(placeService.addPlace(place,userService.findByNum(claims.getSubject())), HttpStatus.OK);
    }

}
