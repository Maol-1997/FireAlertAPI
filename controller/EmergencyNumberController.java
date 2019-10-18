package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.EmergencyNumber;
import com.github.Maol.FireAlertAPI.Service.EmergencyNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergencynumber")
public class EmergencyNumberController {
    @Autowired
    private EmergencyNumberService emergencyNumberService;

    @GetMapping("/")
    public ResponseEntity<List<EmergencyNumber>> findAll() {
        return new ResponseEntity<List<EmergencyNumber>>(emergencyNumberService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{emergencyNumberId}")
    public ResponseEntity<EmergencyNumber> FindById(@PathVariable Long emergencyNumberId) {
        return new ResponseEntity<EmergencyNumber>(emergencyNumberService.findById(emergencyNumberId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EmergencyNumber> add(@RequestBody EmergencyNumber emergencyNumberDTO) {
        EmergencyNumber emergencyNumber = new EmergencyNumber();
        emergencyNumber.setCountry(emergencyNumberDTO.getCountry());
        emergencyNumber.setNumber(emergencyNumberDTO.getNumber());
        return new ResponseEntity<EmergencyNumber>(emergencyNumberService.add(emergencyNumber),HttpStatus.OK);
    }

    @DeleteMapping("/{emergencyNumberId}")
    public ResponseEntity<Void> delete(@PathVariable Long emergencyNumberId) {
        return new ResponseEntity<Void>(emergencyNumberService.delete(emergencyNumberId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("{emergencyNumberId}")
    public ResponseEntity<EmergencyNumber> update(@RequestBody EmergencyNumber emergencyNumberDTO, @PathVariable Long emergencyNumberId) {
        EmergencyNumber emergencyNumber = new EmergencyNumber();
        emergencyNumber.setNumber(emergencyNumberDTO.getNumber());
        emergencyNumber.setCountry(emergencyNumberDTO.getCountry());
        return new ResponseEntity<EmergencyNumber>(emergencyNumberService.update(emergencyNumber, emergencyNumberId), HttpStatus.OK);
    }
}
