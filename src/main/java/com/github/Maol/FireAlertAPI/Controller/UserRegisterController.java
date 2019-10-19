package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.User;
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

    @PostMapping("/")
    public ResponseEntity<User> add(@RequestBody User userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setLocation(userDTO.getLocation());
        user.setToken(userDTO.getToken());
        user.setPassword(userDTO.getPassword());
        user.setFriends(userDTO.getFriends());
        user.setNum(userDTO.getNum());
        return new ResponseEntity<User>(userService.add(user), HttpStatus.OK);
    }
}
