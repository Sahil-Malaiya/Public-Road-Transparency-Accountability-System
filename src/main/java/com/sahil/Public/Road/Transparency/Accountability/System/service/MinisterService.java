package com.sahil.Public.Road.Transparency.Accountability.System.service;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Minister;
import com.sahil.Public.Road.Transparency.Accountability.System.repository.MinisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MinisterService {

    @Autowired
    private MinisterRepository ministerRepository;

    public List<Minister> getAllMinisters() {
        return ministerRepository.findAll();
    }

    public Minister getMinisterById(Long id) {
        return ministerRepository.findById(id).orElse(null);
    }

    public Minister addMinister(Minister minister) {
        minister.setCreatedAt(new Date());
        minister.setUpdatedAt(new Date());
        return ministerRepository.save(minister);
    }

    public Minister updateMinister(Long id, Minister updatedMinister) {
        Minister existing = ministerRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedMinister.getName());
            existing.setMinistry(updatedMinister.getMinistry());
            existing.setConstituency(updatedMinister.getConstituency());
            existing.setContact(updatedMinister.getContact());
            existing.setUpdatedAt(new Date());
            return ministerRepository.save(existing);
        }
        return null;
    }

    public void deleteMinister(Long id) {
        ministerRepository.deleteById(id);
    }
}
