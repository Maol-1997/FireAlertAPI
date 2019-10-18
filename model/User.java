package com.github.Maol.FireAlertAPI.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "num")
    private String num;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @ManyToMany
    private List<User> friends;

    @OneToOne
    @JoinColumn(name = "locationId")
    private UserLocation location;

    @Column(name = "code")
    private String code;

    @Column(name = "inDanger")
    private boolean indanger;
}
