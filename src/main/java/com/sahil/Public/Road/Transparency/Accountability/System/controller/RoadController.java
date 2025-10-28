package com.sahil.Public.Road.Transparency.Accountability.System.controller;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Road;
import com.sahil.Public.Road.Transparency.Accountability.System.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roads")
@CrossOrigin(origins = "*")
public class RoadController {

    @Autowired
    private RoadService roadService;

    @GetMapping
    public List<Road> getAllRoads() {
        return roadService.getAllRoads();
    }

    @GetMapping("/{id}")
    public Road getRoadById(@PathVariable Long id) {
        return roadService.getRoadById(id);
    }

    @PostMapping
    public Road addRoad(@RequestBody Road road) {
        return roadService.addRoad(road);
    }

    @PutMapping("/{id}")
    public Road updateRoad(@PathVariable Long id, @RequestBody Road road) {
        return roadService.updateRoad(id, road);
    }

    @DeleteMapping("/{id}")
    public void deleteRoad(@PathVariable Long id) {
        roadService.deleteRoad(id);
    }
}
