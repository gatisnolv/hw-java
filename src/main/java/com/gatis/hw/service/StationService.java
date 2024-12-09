package com.gatis.hw.service;

import com.gatis.hw.model.Station;
import com.gatis.hw.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class StationService {

    @Autowired
    private StationRepository repository;

    public List<Station> getAll() {
        return repository.findAll();
    }

    public Station getOneByStationId(String id) {
        return repository.findStationByStationIdIgnoreCase(id);
    }

}
