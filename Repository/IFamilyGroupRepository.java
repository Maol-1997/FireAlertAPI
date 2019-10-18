package com.github.Maol.FireAlertAPI.Repository;

import com.github.Maol.FireAlertAPI.model.FamilyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamilyGroupRepository extends JpaRepository<FamilyGroup, Long> {}