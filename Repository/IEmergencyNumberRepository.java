package com.github.Maol.FireAlertAPI.Repository;

import com.github.Maol.FireAlertAPI.Model.EmergencyNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmergencyNumberRepository extends JpaRepository<EmergencyNumber, Long> {}