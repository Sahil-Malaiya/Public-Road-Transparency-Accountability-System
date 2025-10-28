package com.sahil.Public.Road.Transparency.Accountability.System.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // name of the complainant

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private String roadName;

    @Column(nullable = true)
    private String location;

    @Column(nullable = false)
    private String status; // PENDING / RESOLVED

    private LocalDateTime createdAt;
}