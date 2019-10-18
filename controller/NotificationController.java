package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.DTO.NotificationFriend;
import com.github.Maol.FireAlertAPI.Model.DTO.NotificationZoneDTO;
import com.github.Maol.FireAlertAPI.Model.DangerZone;
import com.github.Maol.FireAlertAPI.Model.UnverifiedFire;
import com.github.Maol.FireAlertAPI.Model.User;
import com.github.Maol.FireAlertAPI.Service.DangerZoneService;
import com.github.Maol.FireAlertAPI.Service.UnverifiedFireService;
import com.github.Maol.FireAlertAPI.Service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    private DangerZoneService dangerZoneService;

    @Autowired
    private UnverifiedFireService unverifiedFireService;

    @Autowired
    private UserService userService;

    @PostMapping("/nearzone")
    public ResponseEntity<NotificationZoneDTO> nearZone(@RequestAttribute("claims") final Claims claims) {
        User user = userService.findByNum(claims.getSubject());
        DangerZone dangerZone = dangerZoneService.check(user.getLocation());
        UnverifiedFire unverifiedFire = unverifiedFireService.check(user.getLocation());
        boolean flag = false;
        NotificationZoneDTO notificationZoneDTO = new NotificationZoneDTO();
        if (dangerZone != null) {
            notificationZoneDTO.setIsnear(true);
            notificationZoneDTO.setDistance(dangerZone.getDistance());
            flag = true;
        } else if (unverifiedFire != null) {
            notificationZoneDTO.setIsnear(true);
            notificationZoneDTO.setDistance(unverifiedFire.getDistance());
        }
        if (dangerZone == null && unverifiedFire == null) {
            notificationZoneDTO.setIsnear(false);
            notificationZoneDTO.setDistance(0);
            flag = false;
        }
        if(user.isIndanger() != flag) {
            user.setIndanger(flag);
            userService.update(user,user.getId());
        }
        return new ResponseEntity<NotificationZoneDTO>(notificationZoneDTO, HttpStatus.OK);
    }

    @GetMapping("/friend")
    public ResponseEntity<NotificationFriend> friendInDanger(@RequestAttribute("claims") final Claims claims){
        NotificationFriend notificationFriend = new NotificationFriend();
        User user = userService.findByNum(claims.getSubject());
        for(User f : user.getFriends()){
            if(f.isIndanger()) {
                notificationFriend.getFriends().add(f);
                notificationFriend.setFriendInDanger(true);
            }
        }
        return new ResponseEntity<NotificationFriend>(notificationFriend,HttpStatus.OK);
    }


}
