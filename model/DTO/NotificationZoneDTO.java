package com.github.Maol.FireAlertAPI.Model.DTO;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class NotificationZoneDTO {
    boolean isnear;
    double distance;
}
