package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.DangerZone;
import com.github.Maol.FireAlertAPI.Model.DTO.NotificationZoneDTO;
import com.github.Maol.FireAlertAPI.Model.UnverifiedFire;
import com.github.Maol.FireAlertAPI.Service.DangerZoneService;
import com.github.Maol.FireAlertAPI.Service.UnverifiedFireService;
import com.github.Maol.FireAlertAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/nearzone")
    public ResponseEntity<NotificationZoneDTO> nearZone(@RequestBody String login) {
        DangerZone dangerZone = dangerZoneService.check(userService.findByLogin(login).getLocation());
        UnverifiedFire unverifiedFire = unverifiedFireService.check(userService.findByLogin(login).getLocation());
        NotificationZoneDTO notificationZoneDTO = new NotificationZoneDTO();
        if (dangerZone != null) {
            notificationZoneDTO.setIsnear(true);
            notificationZoneDTO.setDistance(dangerZone.getDistance());
        } else if (unverifiedFire != null) {
            notificationZoneDTO.setIsnear(true);
            notificationZoneDTO.setDistance(unverifiedFire.getDistance());
        }
        if (dangerZone == null && unverifiedFire == null) {
            notificationZoneDTO.setIsnear(false);
            notificationZoneDTO.setDistance(0);
        }
        return new ResponseEntity<NotificationZoneDTO>(notificationZoneDTO, HttpStatus.OK);
    }
}
