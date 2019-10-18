package com.github.Maol.FireAlertAPI.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "emergency_number")
public class EmergencyNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numberId")
    private Long id;

    @Column(name = "number")
    @NotNull
    private int number;

    @Column(name = "country")
    @NotNull
    private String country;
}
