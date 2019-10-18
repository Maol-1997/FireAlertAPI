package com.github.Maol.FireAlertAPI.controller;

import com.github.Maol.FireAlertAPI.model.DangerZone;
import com.github.Maol.FireAlertAPI.service.DangerZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dangerzone")
public class DangerZoneController {
    @Autowired
    private DangerZoneService dangerZoneService;

    @GetMapping("/")
    public ResponseEntity<List<DangerZone>> findAll() {
        return new ResponseEntity<List<DangerZone>>(dangerZoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<DangerZone> FindById(@PathVariable Long dangerZoneId) {
        return new ResponseEntity<DangerZone>(dangerZoneService.findById(dangerZoneId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DangerZone> add(@RequestBody DangerZone dangerZoneDTO) {
        DangerZone dangerZone = new DangerZone();
        dangerZone.setLongitude(dangerZoneDTO.getLongitude());
        dangerZone.setLatitude(dangerZoneDTO.getLatitude());
        return new ResponseEntity<DangerZone>(dangerZoneService.add(dangerZone),HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> delete(@PathVariable Long dangerZoneId) {
        return new ResponseEntity<Void>(dangerZoneService.delete(dangerZoneId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("{locationId}")
    public ResponseEntity<DangerZone> update(@RequestBody DangerZone dangerZoneDTO, @PathVariable Long dangerZoneId) {
        DangerZone dangerZone = new DangerZone();
        dangerZone.setLongitude(dangerZoneDTO.getLongitude());
        dangerZone.setLatitude(dangerZoneDTO.getLatitude());
        return new ResponseEntity<DangerZone>(dangerZoneService.update(dangerZone, dangerZoneId), HttpStatus.OK);
    }
}
