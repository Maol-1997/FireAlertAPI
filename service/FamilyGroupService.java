package com.github.Maol.FireAlertAPI.service;

import com.github.Maol.FireAlertAPI.Repository.IFamilyGroupRepository;
import com.github.Maol.FireAlertAPI.exceptions.FamilyGroupNotFoundException;
import com.github.Maol.FireAlertAPI.model.FamilyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyGroupService {
    @Autowired
    private IFamilyGroupRepository familyGroupRepository;

    public List<FamilyGroup> findAll() {
        return familyGroupRepository.findAll();
    }

    public FamilyGroup add(FamilyGroup familyGroup) {
        familyGroupRepository.save(familyGroup);
        return familyGroup;
    }

    public FamilyGroup findById(Long familyGroupId) {
        return familyGroupRepository.findById(familyGroupId).orElseThrow(() -> new FamilyGroupNotFoundException(familyGroupId));
    }

    public Void delete(Long familyGroupId) {
        familyGroupRepository.deleteById(familyGroupId);
        return null;
    }

    public FamilyGroup update(FamilyGroup newfamilyGroup, Long familyGroupId) {
        return familyGroupRepository.findById(familyGroupId).map(familyGroup -> {
            familyGroup.setUsers(newfamilyGroup.getUsers());
            return familyGroupRepository.save(familyGroup);
        }).orElseThrow(() -> new FamilyGroupNotFoundException(familyGroupId));
    }
}
