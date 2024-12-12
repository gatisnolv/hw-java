package com.gatis.hw.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StationNotFoundException extends RuntimeException {

    private final String stationId;

}
