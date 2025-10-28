package com.sahil.Public.Road.Transparency.Accountability.System.service;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Road;
import com.sahil.Public.Road.Transparency.Accountability.System.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoadService {

    @Autowired
    private RoadRepository roadRepository;

    public List<Road> getAllRoads() {
        return roadRepository.findAll();
    }

    public Road getRoadById(Long id) {
        return roadRepository.findById(id).orElse(null);
    }

    public Road addRoad(Road road) {
        road.setCreatedAt(new Date());
        road.setUpdatedAt(new Date());
        return roadRepository.save(road);
    }

    public Road updateRoad(Long id, Road updatedRoad) {
        Road existing = roadRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setProjectCode(updatedRoad.getProjectCode());
            existing.setName(updatedRoad.getName());
            existing.setDistrict(updatedRoad.getDistrict());
            existing.setState(updatedRoad.getState());
            existing.setPincode(updatedRoad.getPincode());
            existing.setStartDate(updatedRoad.getStartDate());
            existing.setEndDate(updatedRoad.getEndDate());
            existing.setTotalCost(updatedRoad.getTotalCost());
            existing.setStatus(updatedRoad.getStatus());
            existing.setDocumentsUrl(updatedRoad.getDocumentsUrl());
            existing.setLocation(updatedRoad.getLocation());
            existing.setContractor(updatedRoad.getContractor());
            existing.setOfficer(updatedRoad.getOfficer());
            existing.setMinister(updatedRoad.getMinister());
            existing.setMaintenanceFirm(updatedRoad.getMaintenanceFirm());
            existing.setUpdatedAt(new Date());
            return roadRepository.save(existing);
        }
        return null;
    }

    public void deleteRoad(Long id) {
        roadRepository.deleteById(id);
    }
}
