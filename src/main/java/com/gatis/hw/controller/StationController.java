package com.gatis.hw.controller;

import com.gatis.hw.dto.StationDTO;
import com.gatis.hw.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("station")
public class StationController {

    @Autowired
    StationService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StationDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "{stationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StationDTO getOne(@PathVariable String stationId) {
        return service.getOneByStationId(stationId);
    }

}
