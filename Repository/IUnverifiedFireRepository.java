package com.github.Maol.FireAlertAPI.Repository;

import com.github.Maol.FireAlertAPI.Model.UnverifiedFire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnverifiedFireRepository extends JpaRepository<UnverifiedFire, Long> {}