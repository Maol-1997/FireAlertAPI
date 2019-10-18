package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.FamilyGroup;
import com.github.Maol.FireAlertAPI.Service.FamilyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familygroup")
public class FamilyGroupController {
    @Autowired
    private FamilyGroupService familyGroupService;

    @GetMapping("/")
    public ResponseEntity<List<FamilyGroup>> findAll() {
        return new ResponseEntity<List<FamilyGroup>>(familyGroupService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{familyGroupId}")
    public ResponseEntity<FamilyGroup> FindById(@PathVariable Long familyGroupId) {
        return new ResponseEntity<FamilyGroup>(familyGroupService.findById(familyGroupId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<FamilyGroup> add(@RequestBody FamilyGroup familyGroupDTO) {
        FamilyGroup familyGroup = new FamilyGroup();
        familyGroup.setUsers(familyGroupDTO.getUsers());
        return new ResponseEntity<FamilyGroup>(familyGroupService.add(familyGroup),HttpStatus.OK);
    }

    @DeleteMapping("/{familyGroupId}")
    public ResponseEntity<Void> delete(@PathVariable Long familyGroupId) {
        return new ResponseEntity<Void>(familyGroupService.delete(familyGroupId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("{familyGroupId}")
    public ResponseEntity<FamilyGroup> update(@RequestBody FamilyGroup familyGroupDTO, @PathVariable Long familyGroupId) {
        FamilyGroup familyGroup = new FamilyGroup();
        familyGroup.setUsers(familyGroupDTO.getUsers());
        return new ResponseEntity<FamilyGroup>(familyGroupService.update(familyGroup, familyGroupId), HttpStatus.OK);
    }
}
