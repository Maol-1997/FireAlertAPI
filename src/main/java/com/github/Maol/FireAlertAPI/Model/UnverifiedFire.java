package com.github.Maol.FireAlertAPI.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "unverifiedfire")
public class UnverifiedFire extends Location {
    private int reports = 1;
    private DangerZone.magnitudlist magnitud;
    private double distance;
}
