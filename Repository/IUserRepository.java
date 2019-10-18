package com.github.Maol.FireAlertAPI.Repository;

import com.github.Maol.FireAlertAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {}
