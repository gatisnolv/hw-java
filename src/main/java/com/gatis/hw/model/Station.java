package com.gatis.hw.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("_id")
    @Column(name = "_id")
    private Integer id;

    @JsonProperty("STATION_ID")
    @Column(name = "STATION_ID")
    private String stationId;

    @JsonProperty("NAME")
    @Column(name = "NAME")
    private String name;

    @JsonProperty("WMO_ID")
    @Column(name = "WMO_ID")
    private String wmoId;

    @JsonProperty("BEGIN_DATE")
    @Column(name = "BEGIN_DATE")
    private LocalDateTime beginDate;

    @JsonProperty("END_DATE")
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @JsonProperty("LATITUDE")
    @Column(name = "LATITUDE")
    private float latitude;

    @JsonProperty("LONGITUDE")
    @Column(name = "LONGITUDE")
    private float longitude;

    @JsonProperty("GAUSS1")
    @Column(name = "GAUSS1")
    private String gauss1;

    @JsonProperty("GAUSS2")
    @Column(name = "GAUSS2")
    private String gauss2;

    @JsonProperty("GEOGR1")
    @Column(name = "GEOGR1")
    private float geogr1;

    @JsonProperty("GEOGR2")
    @Column(name = "GEOGR2")
    private float geogr2;

    @JsonProperty("ELEVATION")
    @Column(name = "ELEVATION")
    private float elevation;

    @JsonProperty("ELEVATION_PRESSURE")
    @Column(name = "ELEVATION_PRESSURE")
    private String elevationPressure;
}
