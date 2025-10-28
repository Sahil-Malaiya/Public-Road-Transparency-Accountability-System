package com.sahil.Public.Road.Transparency.Accountability.System.controller;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.MaintenanceFirm;
import com.sahil.Public.Road.Transparency.Accountability.System.service.MaintenanceFirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-firms")
@CrossOrigin(origins = "*")
public class MaintenanceFirmController {

    @Autowired
    private MaintenanceFirmService maintenanceFirmService;

    @GetMapping
    public List<MaintenanceFirm> getAllFirms() {
        return maintenanceFirmService.getAllFirms();
    }

    @GetMapping("/{id}")
    public MaintenanceFirm getFirmById(@PathVariable Long id) {
        return maintenanceFirmService.getFirmById(id);
    }

    @PostMapping
    public MaintenanceFirm addFirm(@RequestBody MaintenanceFirm firm) {
        return maintenanceFirmService.addFirm(firm);
    }

    @PutMapping("/{id}")
    public MaintenanceFirm updateFirm(@PathVariable Long id, @RequestBody MaintenanceFirm firm) {
        return maintenanceFirmService.updateFirm(id, firm);
    }

    @DeleteMapping("/{id}")
    public void deleteFirm(@PathVariable Long id) {
        maintenanceFirmService.deleteFirm(id);
    }
}
