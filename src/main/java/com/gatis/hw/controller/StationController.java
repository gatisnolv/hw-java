package com.gatis.hw.controller;

import com.gatis.hw.service.StationsDataDownloadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.ConnectException;
import java.net.http.HttpTimeoutException;
import java.util.concurrent.CancellationException;

@RestController
@RequestMapping("station")
@Slf4j
public class StationController {

    @Autowired
    StationsDataDownloadService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll() {
        return "all stations";
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOne(@PathVariable String id) {
        return "one station";
    }

    // TODO does the reason string show up in openapi?
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Network unreachable")
    @ExceptionHandler({ConnectException.class})
    public void handleConnectException(Exception e) {
        log.error("Network unreachable");
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Request timed out")
    @ExceptionHandler({HttpTimeoutException.class, CancellationException.class})
    public void handleHttpTimeoutException(Exception e) {
        log.error("Request timed out");
    }

}
