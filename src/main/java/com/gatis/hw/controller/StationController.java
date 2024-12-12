package com.gatis.hw.controller;

import com.gatis.hw.dto.StationDTO;
import com.gatis.hw.service.StationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.ConnectException;
import java.net.http.HttpTimeoutException;
import java.util.List;
import java.util.concurrent.CancellationException;

@RestController
@RequestMapping("station")
@Slf4j
public class StationController {

    @Autowired
    private StationsService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StationDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "{stationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StationDTO getOne(@PathVariable String stationId) {
        return service.getOneByStationId(stationId);
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler({ConnectException.class})
    public void handleConnectException(Exception e) {
        log.error("Network unreachable");
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler({HttpTimeoutException.class, CancellationException.class})
    public void handleHttpTimeoutException(Exception e) {
        log.error("Request timed out");
    }

}
