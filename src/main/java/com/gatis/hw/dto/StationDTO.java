package com.gatis.hw.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record StationDTO(
        @JsonProperty("_id") Integer id, // TODO should I include the id field from data source?
        @JsonProperty("STATION_ID") String stationId,
        @JsonProperty("NAME") String name,
        @JsonProperty("WMO_ID") String wmoId,
        @JsonProperty("BEGIN_DATE") LocalDateTime beginDate,
        @JsonProperty("END_DATE") LocalDateTime endDate,
        @JsonProperty("LATITUDE") float latitude,
        @JsonProperty("LONGITUDE") float longitude,
        @JsonProperty("GAUSS1") String gauss1,
        @JsonProperty("GAUSS2") String gauss2,
        @JsonProperty("GEOGR1") float geogr1,
        @JsonProperty("GEOGR2") float geogr2,
        @JsonProperty("ELEVATION") float elevation,
        @JsonProperty("ELEVATION_PRESSURE") String elevationPressure
) {
}
