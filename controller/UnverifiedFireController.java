package com.github.Maol.FireAlertAPI.Controller;

import com.github.Maol.FireAlertAPI.Model.UnverifiedFire;
import com.github.Maol.FireAlertAPI.Service.UnverifiedFireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unverifiedfire")
public class UnverifiedFireController {
    @Autowired
    private UnverifiedFireService unverifiedFireService;

    @GetMapping("/")
    public ResponseEntity<List<UnverifiedFire>> findAll() {
        return new ResponseEntity<List<UnverifiedFire>>(unverifiedFireService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<UnverifiedFire> FindById(@PathVariable Long unverifiedfireId) {
        return new ResponseEntity<UnverifiedFire>(unverifiedFireService.findById(unverifiedfireId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UnverifiedFire> add(@RequestBody UnverifiedFire unverifiedFireDTO) {
        UnverifiedFire unverifiedFire = new UnverifiedFire();
        unverifiedFire.setLongitude(unverifiedFireDTO.getLongitude());
        unverifiedFire.setLatitude(unverifiedFireDTO.getLatitude());
        unverifiedFire.setReports(unverifiedFireDTO.getReports());
        return new ResponseEntity<UnverifiedFire>(unverifiedFireService.add(unverifiedFire),HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> delete(@PathVariable Long dangerZoneId) {
        return new ResponseEntity<Void>(unverifiedFireService.delete(dangerZoneId), HttpStatus.NO_CONTENT);
    }

    @PutMapping("{locationId}")
    public ResponseEntity<UnverifiedFire> update(@RequestBody UnverifiedFire unverifiedFireDTO, @PathVariable Long unverifiedfireId) {
        UnverifiedFire unverifiedFire = new UnverifiedFire();
        unverifiedFire.setLongitude(unverifiedFireDTO.getLongitude());
        unverifiedFire.setLatitude(unverifiedFireDTO.getLatitude());
        unverifiedFire.setReports(unverifiedFireDTO.getReports());
        return new ResponseEntity<UnverifiedFire>(unverifiedFireService.update(unverifiedFire, unverifiedfireId), HttpStatus.OK);
    }
}
