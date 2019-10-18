package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.User;
import com.github.Maol.FireAlertAPI.Service.UserService;
import io.jsonwebtoken.Claims;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/me")
public class MeController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestAttribute("claims") final Claims claims) throws NotFoundException {
        return new ResponseEntity<User>(userService.findByNum(claims.getSubject()), HttpStatus.OK);
    }

}