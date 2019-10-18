package com.github.Maol.FireAlertAPI.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationId")
    protected Long id;

    @Column(name = "longitude")
    @NotNull
    protected double longitude;

    @Column(name = "latitude")
    @NotNull
    protected double latitude;

    protected double distance;

    public boolean isNear(Location loc2, double radius) {
        this.distance = Math.sqrt((Math.pow(loc2.getLatitude()-this.getLatitude(),2.0D))+(Math.pow(loc2.getLongitude()-this.getLongitude(),2.0D)));
        if(distance <= radius)
            return true;
        return false;
    }
}
