package com.gatis.hw.service;

import com.gatis.hw.dto.StationDTO;
import com.gatis.hw.exception.StationNotFoundException;
import com.gatis.hw.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository repository;

    public List<StationDTO> getAll() {
        return repository.findBy();
    }

    public StationDTO getOneByStationId(String stationId) {
        return repository.findOptionalByStationIdIgnoreCase(stationId).orElseThrow(() -> new StationNotFoundException(stationId));
    }

}
