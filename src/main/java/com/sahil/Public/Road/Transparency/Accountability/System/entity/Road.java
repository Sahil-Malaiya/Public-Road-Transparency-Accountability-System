package com.sahil.Public.Road.Transparency.Accountability.System.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectCode;
    private String name;
    private String district;
    private String state;
    private String pincode;
    private Date startDate;
    private Date endDate;
    private Double totalCost;
    private String status;
    private String documentsUrl;
    private String location;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;

    @ManyToOne
    @JoinColumn(name = "minister_id")
    private Minister minister;

    @ManyToOne
    @JoinColumn(name = "maintenance_firm_id")
    private MaintenanceFirm maintenanceFirm;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();
}
