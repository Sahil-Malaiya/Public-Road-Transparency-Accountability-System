package com.sahil.Public.Road.Transparency.Accountability.System.controller;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Minister;
import com.sahil.Public.Road.Transparency.Accountability.System.service.MinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ministers")
@CrossOrigin(origins = "*")
public class MinisterController {

    @Autowired
    private MinisterService ministerService;

    @GetMapping
    public List<Minister> getAllMinisters() {
        return ministerService.getAllMinisters();
    }

    @GetMapping("/{id}")
    public Minister getMinisterById(@PathVariable Long id) {
        return ministerService.getMinisterById(id);
    }

    @PostMapping
    public Minister addMinister(@RequestBody Minister minister) {
        return ministerService.addMinister(minister);
    }

    @PutMapping("/{id}")
    public Minister updateMinister(@PathVariable Long id, @RequestBody Minister minister) {
        return ministerService.updateMinister(id, minister);
    }

    @DeleteMapping("/{id}")
    public void deleteMinister(@PathVariable Long id) {
        ministerService.deleteMinister(id);
    }
}
