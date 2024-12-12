package com.gatis.hw.service;

import com.gatis.hw.dto.StationDTO;
import com.gatis.hw.exception.StationNotFoundException;
import com.gatis.hw.repository.StationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Service
@Slf4j
public class StationService {

    @Autowired
    private StationRepository repository;

    private final RestClient restClient;

    public StationService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public List<StationDTO> getAll() {
        return repository.findBy();
    }

    public StationDTO getOneByStationId(String stationId) {
        return repository.findOptionalByStationIdIgnoreCase(stationId).orElseThrow(() -> new StationNotFoundException(stationId));
    }

    public void updateData() {
        boolean downloadSuccessful = downloadStationsData();
        if (downloadSuccessful) {
            repository.deleteAll();
            repository.loadDataFromFile();
        }
    }

    boolean downloadStationsData() {
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
