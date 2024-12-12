package com.gatis.hw.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


@Service
@Slf4j
public class StationsDataDownloadService {

    private final RestClient restClient;

    public StationsDataDownloadService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public boolean downloadStationsData() {
        String uri = "https://data.gov.lv/dati/lv/datastore/dump/c32c7afd-0d05-44fd-8b24-1de85b4bf11d?bom=True";
        return Boolean.TRUE.equals(restClient.get().uri(uri).exchange((request, response) -> {
            if (HttpStatus.OK == response.getStatusCode()) {
                File stationsFile = new File("stations.csv");
                Files.copy(response.getBody(), stationsFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                log.info("Updated stations data");
                return true;
            } else {
                log.error("Unexpected response code: {}", response.getStatusCode());
                return false;
            }
        }));
    }

}
