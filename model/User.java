package com.github.Maol.FireAlertAPI.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "apellido")
    @NotNull
    private String apellido;

    @OneToOne
    @JoinColumn(name = "locationId")
    private UserLocation location;
}
