package com.sahil.Public.Road.Transparency.Accountability.System.controller;

import com.sahil.Public.Road.Transparency.Accountability.System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class AdminAnalyticsController {

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private OfficerRepository officerRepository;

    @Autowired
    private MinisterRepository ministerRepository;

    @Autowired
    private MaintenanceFirmRepository maintenanceFirmRepository;

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();

        stats.put("totalContractors", contractorRepository.count());
        stats.put("totalOfficers", officerRepository.count());
        stats.put("totalMinisters", ministerRepository.count());
        stats.put("totalFirms", maintenanceFirmRepository.count());
        stats.put("totalRoads", roadRepository.count());
        stats.put("totalComplaints", complaintRepository.count());

        long completedRoads = roadRepository.findAll()
                .stream()
                .filter(r -> "COMPLETED".equalsIgnoreCase(r.getStatus()))
                .count();

        stats.put("completedRoads", completedRoads);
        stats.put("pendingRoads", roadRepository.count() - completedRoads);

        long resolvedComplaints = complaintRepository.findAll()
                .stream()
                .filter(c -> "RESOLVED".equalsIgnoreCase(c.getStatus()))
                .count();

        stats.put("resolvedComplaints", resolvedComplaints);
        stats.put("pendingComplaints", complaintRepository.count() - resolvedComplaints);

        return stats;
    }
}
