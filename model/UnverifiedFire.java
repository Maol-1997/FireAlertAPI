package com.github.Maol.FireAlertAPI.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "unverifiedfire")
public class UnverifiedFire extends Location {
    private int reports;
    private double distance;
}
