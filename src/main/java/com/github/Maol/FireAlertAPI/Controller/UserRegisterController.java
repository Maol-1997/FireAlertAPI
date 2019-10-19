package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.User;
import com.github.Maol.FireAlertAPI.Model.UserLocation;
import com.github.Maol.FireAlertAPI.Service.UserLocationService;
import com.github.Maol.FireAlertAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserLocationService userLocationService;

    @PostMapping("/")
    public ResponseEntity<User> add(@RequestBody User userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        UserLocation userLocation = new UserLocation();
        userLocation.setLatitude(0.0);
        userLocation.setLongitude(0.0);
        user.setLocation(userLocationService.add(userLocation));
        user.setToken(userDTO.getToken());
        user.setPassword(userDTO.getPassword());
        user.setFriends(userDTO.getFriends());
        user.setNum(userDTO.getNum());
        return new ResponseEntity<User>(userService.add(user), HttpStatus.OK);
    }
}
