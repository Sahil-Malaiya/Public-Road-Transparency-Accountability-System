package com.sahil.Public.Road.Transparency.Accountability.System.controller;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Officer;
import com.sahil.Public.Road.Transparency.Accountability.System.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
@CrossOrigin(origins = "*")
public class OfficerController {

    @Autowired
    private OfficerService officerService;

    @GetMapping
    public List<Officer> getAllOfficers() {
        return officerService.getAllOfficers();
    }

    @GetMapping("/{id}")
    public Officer getOfficerById(@PathVariable Long id) {
        return officerService.getOfficerById(id);
    }

    @PostMapping
    public Officer addOfficer(@RequestBody Officer officer) {
        return officerService.addOfficer(officer);
    }

    @PutMapping("/{id}")
    public Officer updateOfficer(@PathVariable Long id, @RequestBody Officer officer) {
        return officerService.updateOfficer(id, officer);
    }

    @DeleteMapping("/{id}")
    public void deleteOfficer(@PathVariable Long id) {
        officerService.deleteOfficer(id);
    }
}
