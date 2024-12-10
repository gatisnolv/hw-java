package com.gatis.hw.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
//    {"id":"_id","type":"int"}
//    {"id":"STATION_ID","type":"text"}
//    {"id":"NAME","type":"text"}
//    {"id":"WMO_ID","type":"text"}
//    {"id":"BEGIN_DATE","type":"timestamp"}
//    {"id":"END_DATE","type":"timestamp"}
//    {"id":"LATITUDE","type":"numeric"}
//    {"id":"LONGITUDE","type":"numeric"}
//    {"id":"GAUSS1","type":"text"}
//    {"id":"GAUSS2","type":"text"}
//    {"id":"GEOGR1","type":"numeric"}
//    {"id":"GEOGR2","type":"numeric"}
//    {"id":"ELEVATION","type":"numeric"}
//    {"id":"ELEVATION_PRESSURE","type":"text"}]

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primaryKey;

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
