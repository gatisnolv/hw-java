package com.gatis.hw.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.file.Paths;
import java.time.Duration;

@Service
@Slf4j
public class StationsDataDownloadService {

    HttpClient client = HttpClient.newHttpClient();

    public boolean downloadStationsData() throws IOException, InterruptedException {
        String uri = "https://data.gov.lv/dati/lv/datastore/dump/c32c7afd-0d05-44fd-8b24-1de85b4bf11d?bom=True";
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri)).timeout(Duration.ofMinutes(1)).build();
        try {
            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("stations.csv")));
            if (HttpStatusCode.valueOf(response.statusCode()) == HttpStatus.OK) return true;
            else log.error("Unexpected response code: {}", response.statusCode());
        } catch (ConnectException e) {
            log.error("Network unreachable");
        } catch (HttpTimeoutException e) {
            log.error("Request timed out");
        }
        return false;
    }

}
