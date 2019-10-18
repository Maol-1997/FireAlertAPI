package com.github.Maol.FireAlertAPI.controller;

import com.github.Maol.FireAlertAPI.model.DangerZone;
import com.github.Maol.FireAlertAPI.model.UnverifiedFire;
import com.github.Maol.FireAlertAPI.service.DangerZoneService;
import com.github.Maol.FireAlertAPI.service.UnverifiedFireService;
import com.github.Maol.FireAlertAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private DangerZoneService dangerZoneService;

    @Autowired
    private UnverifiedFireService unverifiedFireService;

    @Autowired
    private UserService userService;

    @PostMapping("/neardangerzone")
    public ResponseEntity<DangerZone> nearDangerZone(String login) {
        DangerZone dangerZone = dangerZoneService.check(userService.findByLogin(login).getLocation());
        if (dangerZone != null)
            return new ResponseEntity<DangerZone>(dangerZone, HttpStatus.OK);
        return new ResponseEntity<DangerZone>(new DangerZone(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/nearunverifiedfire")
    public ResponseEntity<UnverifiedFire> nearUnverifiedFire(String login) {
        UnverifiedFire unverifiedFire = unverifiedFireService.check(userService.findByLogin(login).getLocation());
        if (unverifiedFire != null)
            return new ResponseEntity<UnverifiedFire>(unverifiedFire, HttpStatus.OK);
        return new ResponseEntity<UnverifiedFire>(new UnverifiedFire(), HttpStatus.NOT_FOUND);
    }
}
