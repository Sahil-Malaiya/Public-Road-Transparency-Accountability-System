package com.sahil.Public.Road.Transparency.Accountability.System.service;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Officer;
import com.sahil.Public.Road.Transparency.Accountability.System.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

    public List<Officer> getAllOfficers() {
        return officerRepository.findAll();
    }

    public Officer getOfficerById(Long id) {
        return officerRepository.findById(id).orElse(null);
    }

    public Officer addOfficer(Officer officer) {
        officer.setCreatedAt(new Date());
        officer.setUpdatedAt(new Date());
        return officerRepository.save(officer);
    }

    public Officer updateOfficer(Long id, Officer updatedOfficer) {
        Officer existing = officerRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedOfficer.getName());
            existing.setDesignation(updatedOfficer.getDesignation());
            existing.setDepartment(updatedOfficer.getDepartment());
            existing.setOfficeContact(updatedOfficer.getOfficeContact());
            existing.setEmail(updatedOfficer.getEmail());
            existing.setUpdatedAt(new Date());
            return officerRepository.save(existing);
        }
        return null;
    }

    public void deleteOfficer(Long id) {
        officerRepository.deleteById(id);
    }
}
