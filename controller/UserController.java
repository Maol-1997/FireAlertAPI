package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.User;
import com.github.Maol.FireAlertAPI.Service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> FindById(@PathVariable Long userId) {
        return new ResponseEntity<User>(userService.findById(userId), HttpStatus.OK);
    }

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
        return new ResponseEntity<User>(userService.add(user),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        return new ResponseEntity<Void>(userService.delete(userId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("{userId}")
    public ResponseEntity<User> update(@RequestBody User userDTO, @PathVariable Long userId) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setLocation(userDTO.getLocation());
        user.setToken(userDTO.getToken());
        user.setPassword(userDTO.getPassword());
        user.setFriends(userDTO.getFriends());
        user.setNum(userDTO.getNum());
        return new ResponseEntity<User>(userService.update(user, userId), HttpStatus.OK);
    }

    @PostMapping("/friend")
    public ResponseEntity<User> addFriend(@RequestBody String num,@RequestAttribute("claims") final Claims claims){
        return new ResponseEntity<User>(userService.addFriend(num,userService.findByNum(claims.getSubject())),HttpStatus.OK);
    }
}
