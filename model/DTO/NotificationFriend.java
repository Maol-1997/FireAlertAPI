package com.github.Maol.FireAlertAPI.Model.DTO;

import com.github.Maol.FireAlertAPI.Model.User;
import lombok.Data;

import java.util.List;

@Data
public class NotificationFriend {
    private boolean friendInDanger = false;
    private List<User> friends;
}
