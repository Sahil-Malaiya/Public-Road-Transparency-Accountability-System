package com.sahil.Public.Road.Transparency.Accountability.System.repository;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}