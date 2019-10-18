package com.github.Maol.FireAlertAPI.Service;

import com.github.Maol.FireAlertAPI.Repository.IUserRepository;
import com.github.Maol.FireAlertAPI.Exception.UserNotFoundException;
import com.github.Maol.FireAlertAPI.Model.User;
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
        user.setCode(Hash((user.getName() + user.getLastname()+ System.currentTimeMillis()).toCharArray()));
        userRepository.save(user);
        return user;
    }

    public User addFriend(String num,User user) {
        user.getFriends().add(userRepository.findByNum(num));
        System.out.println(userRepository.findByNum(num));
        System.out.println(user.getFriends());
        userRepository.save(user);
        return user;
    }


    private String Hash(char[] str) {
        char[] allowedSymbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] hash = new char[6];

        for (int i = 0; i < str.length; i++) {
            hash[i % 6] = (char) (hash[i % 6] ^ str[i]);
        }

        for (int i = 0; i < 6; i++) {
            hash[i] = allowedSymbols[hash[i] % allowedSymbols.length];
        }

        return new String(hash);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public Void delete(Long userId) {
        userRepository.deleteById(userId);
        return null;
    }

    public boolean exist(String num){
        return userRepository.existsByNum(num);
    }

    public User update(User newuser, Long userId) {
        return userRepository.findById(userId).map(user -> {
            user.setName(newuser.getName());
            user.setLastname(newuser.getLastname());
            user.setLocation(newuser.getLocation());
            user.setCode(Hash((user.getId() + user.getName() + user.getLastname()).toCharArray()));
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User findByNum(String num) {
        return userRepository.findByNum(num);
    }


}
