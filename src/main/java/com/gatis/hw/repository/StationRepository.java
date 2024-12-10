package com.gatis.hw.repository;

import com.gatis.hw.dto.StationDTO;
import com.gatis.hw.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {
    StationDTO findStationByStationIdIgnoreCase(String stationId);

    List<StationDTO> findBy();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO STATION SELECT *, RANDOM_UUID() AS PRIMARY_KEY FROM CSVREAD('stations-fallback.csv');")
    void loadDataFromFile(String filename);


    @Query(nativeQuery = true, value = "SELECT * FROM CSVREAD('stations-fallback.csv');")
    List<Station> read();
}
