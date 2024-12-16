package com.gatis.hw.service;

import com.gatis.hw.repository.StationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(StationService.class)
class StationServiceTest {

    @MockitoBean
    StationRepository repository;

    @Autowired
    StationService service;

    @Autowired
    MockRestServiceServer server;

    @Test
    void updateData() {
    }

    @Test
    void downloadStationsData() {
        server.expect(requestTo("https://data.gov.lv/dati/lv/datastore/dump/c32c7afd-0d05-44fd-8b24-1de85b4bf11d?bom=True")).andRespond(withSuccess());

        boolean downloadSuccessful = service.downloadStationsData();

        assertTrue(downloadSuccessful);
    }

}