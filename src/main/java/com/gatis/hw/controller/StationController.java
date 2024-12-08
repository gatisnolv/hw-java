package com.gatis.hw.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("station")
public class StationController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll() {
        return "all stations";
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getOne(@PathVariable String id) {
        return "one station";
    }
}

