package com.gatis.hw.controller;

import com.gatis.hw.model.Station;
import com.gatis.hw.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("station")
public class StationController {

    @Autowired
    StationService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getAll() {
    public List<Station> getAll() {
//        return "all stations";
        return service.getAll();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getOne(@PathVariable String id) {
    public Station getOne(@PathVariable String id) {
//        return "one station";
        return service.getOneByStationId(id);
    }
}

