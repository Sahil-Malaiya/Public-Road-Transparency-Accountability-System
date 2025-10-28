package com.sahil.Public.Road.Transparency.Accountability.System.controller;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Complaint;
import com.sahil.Public.Road.Transparency.Accountability.System.repository.ComplaintRepository;
import com.sahil.Public.Road.Transparency.Accountability.System.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "*")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private EmailService emailService;

    // Single POST endpoint with email + DB save
    @PostMapping
    public ResponseEntity<Complaint> submitComplaint(@RequestBody Complaint complaint) {
        complaint.setCreatedAt(LocalDateTime.now());
        complaint.setStatus("PENDING");

        Complaint savedComplaint = complaintRepository.save(complaint);

        // Send email notification to admin
        emailService.sendComplaintNotification(
                "sahilmalaiya07@gmail.com",
                savedComplaint.getName(),
                savedComplaint.getRoadName(),
                savedComplaint.getLocation(),
                savedComplaint.getMessage()
        );

        return ResponseEntity.ok(savedComplaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
}
