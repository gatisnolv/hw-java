package com.gatis.hw.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PRIMARY_KEY")
    private UUID primaryKey;

    @Column(name = "_id")
    private Integer id;

    @Column(name = "STATION_ID")
    private String stationId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WMO_ID")
    private String wmoId;

    @Column(name = "BEGIN_DATE")
    private LocalDateTime beginDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "LATITUDE")
    private float latitude;

    @Column(name = "LONGITUDE")
    private float longitude;

    @Column(name = "GAUSS1")
    private String gauss1;

    @Column(name = "GAUSS2")
    private String gauss2;

    @Column(name = "GEOGR1")
    private float geogr1;

    @Column(name = "GEOGR2")
    private float geogr2;

    @Column(name = "ELEVATION")
    private float elevation;

    @Column(name = "ELEVATION_PRESSURE")
    private String elevationPressure;

}
