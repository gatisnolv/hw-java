package com.gatis.hw.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Service
public class StationsInfoDownloadService {

    public void downloadStationsInfo() throws IOException, InterruptedException, URISyntaxException {
        // TODO add graceful handling of fail
        // TODO add timeout
        String uri = "https://data.gov.lv/dati/lv/datastore/dump/c32c7afd-0d05-44fd-8b24-1de85b4bf11d?bom=True";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        // downloads into top level dir
        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("stations.csv")));
        // downloads into ./target/classes/com/gatis/hw/stations.json
//        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(getClass().getResource("").toURI()).resolveSibling("stations.json")));
        // downloads into ./target/classes/com/gatis/hw/service/stations.json
//        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(getClass().getResource("").toURI()).resolve("stations.json")));
    }

    public static void get(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("stations.csv")));
    }

    public static void main(String[] args) throws Exception {
        get("https://data.gov.lv/dati/lv/datastore/dump/c32c7afd-0d05-44fd-8b24-1de85b4bf11d?bom=True");
//        String query = "SELECT * from \"c32c7afd-0d05-44fd-8b24-1de85b4bf11d\" WHERE \"STATION_ID\" = 'RIVE99PA'";
//        String uri = "https://data.gov.lv/dati/lv/api/3/action/datastore_search_sql?sql=";
//        String encoded = URLEncoder.encode(query, Charset.defaultCharset());
//        System.out.println(uri + encoded);
    }

}
