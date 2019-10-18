package com.github.Maol.FireAlertAPI.controller;

import com.github.Maol.FireAlertAPI.model.SafeZone;
import com.github.Maol.FireAlertAPI.service.SafeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/safezone")
public class SafeZoneController {
    @Autowired
    private SafeZoneService safeZoneService;

    @GetMapping("/")
    public ResponseEntity<List<SafeZone>> findAll() {
        return new ResponseEntity<List<SafeZone>>(safeZoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<SafeZone> FindById(@PathVariable Long safeZoneId) {
        return new ResponseEntity<SafeZone>(safeZoneService.findById(safeZoneId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SafeZone> add(@RequestBody SafeZone safeZoneDTO) {
        SafeZone safeZone = new SafeZone();
        safeZone.setLongitude(safeZoneDTO.getLongitude());
        safeZone.setLatitude(safeZoneDTO.getLatitude());
        return new ResponseEntity<SafeZone>(safeZoneService.add(safeZone),HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> delete(@PathVariable Long safeZoneId) {
        return new ResponseEntity<Void>(safeZoneService.delete(safeZoneId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("{locationId}")
    public ResponseEntity<SafeZone> update(@RequestBody SafeZone safeZoneDTO, @PathVariable Long safeZoneId) {
        SafeZone safeZone = new SafeZone();
        safeZone.setLongitude(safeZoneDTO.getLongitude());
        safeZone.setLatitude(safeZoneDTO.getLatitude());
        return new ResponseEntity<SafeZone>(safeZoneService.update(safeZone, safeZoneId), HttpStatus.OK);
    }
}
