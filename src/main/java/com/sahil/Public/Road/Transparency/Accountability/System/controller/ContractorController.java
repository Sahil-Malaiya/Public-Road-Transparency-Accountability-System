package com.sahil.Public.Road.Transparency.Accountability.System.controller;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Contractor;
import com.sahil.Public.Road.Transparency.Accountability.System.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contractors")
@CrossOrigin(origins = "*")
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    // Get all contractors
    @GetMapping
    public List<Contractor> getAllContractors() {
        return contractorService.getAllContractors();
    }

    // Get contractor by ID
    @GetMapping("/{id}")
    public Contractor getContractorById(@PathVariable Long id) {
        return contractorService.getContractorById(id);
    }

    // Add contractor
    @PostMapping
    public Contractor addContractor(@RequestBody Contractor contractor) {
        return contractorService.addContractor(contractor);
    }

    // Update contractor
    @PutMapping("/{id}")
    public Contractor updateContractor(@PathVariable Long id, @RequestBody Contractor contractor) {
        return contractorService.updateContractor(id, contractor);
    }

    // Delete contractor
    @DeleteMapping("/{id}")
    public void deleteContractor(@PathVariable Long id) {
        contractorService.deleteContractor(id);
    }
}
