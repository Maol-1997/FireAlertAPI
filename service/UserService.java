package com.github.Maol.FireAlertAPI.service;

import com.github.Maol.FireAlertAPI.model.User;
import com.github.Maol.FireAlertAPI.Repository.IUserRepository;
import com.github.Maol.FireAlertAPI.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        userRepository.save(user);
        return user;
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public Void delete(Long userId) {
        userRepository.deleteById(userId);
        return null;
    }

    public User update(User newuser, Long userId) {
        return userRepository.findById(userId).map(user -> {
            user.setNombre(newuser.getNombre());
            user.setApellido(newuser.getApellido());
            user.setLocation(newuser.getLocation());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(userId));
    }
}
