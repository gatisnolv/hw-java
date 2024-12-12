package com.gatis.hw.controller;

import com.gatis.hw.service.StationsDataDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("station")
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

}
