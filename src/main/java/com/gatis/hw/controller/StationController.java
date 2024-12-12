package com.gatis.hw.controller;

import com.gatis.hw.dto.StationDTO;
import com.gatis.hw.service.StationService;
import com.gatis.hw.exception.StationNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("station")
@Slf4j
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

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ExceptionHandler({StationNotFoundException.class})
    public void handleStationNotFoundException(StationNotFoundException e) {
        log.info("No station with STATION_ID {} found", e.getStationId());
    }

}
