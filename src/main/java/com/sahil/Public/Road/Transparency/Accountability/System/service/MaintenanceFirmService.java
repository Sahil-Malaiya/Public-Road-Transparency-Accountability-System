package com.sahil.Public.Road.Transparency.Accountability.System.service;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.MaintenanceFirm;
import com.sahil.Public.Road.Transparency.Accountability.System.repository.MaintenanceFirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MaintenanceFirmService {

    @Autowired
    private MaintenanceFirmRepository maintenanceFirmRepository;

    public List<MaintenanceFirm> getAllFirms() {
        return maintenanceFirmRepository.findAll();
    }

    public MaintenanceFirm getFirmById(Long id) {
        return maintenanceFirmRepository.findById(id).orElse(null);
    }

    public MaintenanceFirm addFirm(MaintenanceFirm firm) {
        firm.setCreatedAt(new Date());
        firm.setUpdatedAt(new Date());
        return maintenanceFirmRepository.save(firm);
    }

    public MaintenanceFirm updateFirm(Long id, MaintenanceFirm updatedFirm) {
        MaintenanceFirm existing = maintenanceFirmRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedFirm.getName());
            existing.setCompanyRegistration(updatedFirm.getCompanyRegistration());
            existing.setContact(updatedFirm.getContact());
            existing.setEmail(updatedFirm.getEmail());
            existing.setUpdatedAt(new Date());
            return maintenanceFirmRepository.save(existing);
        }
        return null;
    }

    public void deleteFirm(Long id) {
        maintenanceFirmRepository.deleteById(id);
    }
}
