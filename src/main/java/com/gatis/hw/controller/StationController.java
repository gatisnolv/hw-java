package com.gatis.hw.controller;

import com.gatis.hw.dto.StationDTO;
import com.gatis.hw.service.StationService;
import com.gatis.hw.exception.StationNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.net.ConnectException;
import java.net.http.HttpTimeoutException;
import java.util.concurrent.CancellationException;

@RestController
@RequestMapping("station")
@Slf4j
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "X-API-Key", in = SecuritySchemeIn.HEADER)
public class StationController {

    @Autowired
    StationService service;

    @Operation(summary = "Get all stations data")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "All stations data found"))
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StationDTO> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Find one station by STATION_ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Data for station with given STATION_ID found"),
            @ApiResponse(responseCode = "204", description = "No stations with given STATION_ID found")})
    @GetMapping(path = "{stationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StationDTO getOne(@PathVariable String stationId) {
        return service.getOneByStationId(stationId);
    }

    @Operation(summary = "Update stations data from data source over the network")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Stations data updated"),
            @ApiResponse(responseCode = "503", description = "Failed to update stations data due to network issues")})
    @PostMapping
    public void updateData() {
        service.updateData();
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ExceptionHandler({StationNotFoundException.class})
    public void handleStationNotFoundException(StationNotFoundException e) {
        log.info("No station with STATION_ID {} found", e.getStationId());
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
