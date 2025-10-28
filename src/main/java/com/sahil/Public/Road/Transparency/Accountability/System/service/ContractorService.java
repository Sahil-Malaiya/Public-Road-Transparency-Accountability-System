package com.sahil.Public.Road.Transparency.Accountability.System.service;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Contractor;
import com.sahil.Public.Road.Transparency.Accountability.System.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }

    public Contractor getContractorById(Long id) {
        return contractorRepository.findById(id).orElse(null);
    }

    public Contractor addContractor(Contractor contractor) {
        contractor.setCreatedAt(new Date());
        contractor.setUpdatedAt(new Date());
        return contractorRepository.save(contractor);
    }

    public Contractor updateContractor(Long id, Contractor updatedContractor) {
        Contractor existing = contractorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedContractor.getName());
            existing.setCompanyName(updatedContractor.getCompanyName());
            existing.setRegistrationNo(updatedContractor.getRegistrationNo());
            existing.setContact(updatedContractor.getContact());
            existing.setEmail(updatedContractor.getEmail());
            existing.setUpdatedAt(new Date());
            return contractorRepository.save(existing);
        }
        return null;
    }

    public void deleteContractor(Long id) {
        contractorRepository.deleteById(id);
    }
}
