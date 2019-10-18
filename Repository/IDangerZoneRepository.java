package com.github.Maol.FireAlertAPI.Repository;

import com.github.Maol.FireAlertAPI.Model.DangerZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDangerZoneRepository extends JpaRepository<DangerZone, Long> {}