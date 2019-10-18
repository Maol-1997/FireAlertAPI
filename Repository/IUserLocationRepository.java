package com.github.Maol.FireAlertAPI.Repository;

import com.github.Maol.FireAlertAPI.Model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserLocationRepository extends JpaRepository<UserLocation, Long> {}