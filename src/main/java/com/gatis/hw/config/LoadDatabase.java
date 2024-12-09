package com.gatis.hw.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gatis.hw.repository.StationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.h2.tools.Csv;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.time.LocalDateTime;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner runner(StationRepository repository) {
        return args -> {
            // read JSON and load json
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Station>> typeReference = new TypeReference<List<Station>>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/stations-fallback.json");
//            try {
//                List<Station> stations = mapper.readValue(inputStream, typeReference);
//                repository.saveAll(stations);
//                System.out.println("Users Saved!");
//            } catch (IOException e){
//                System.out.println("Unable to save users: " + e.getMessage());
//            }
//            String filename = "stations-fallback.csv";
//            String path = new ClassPathResource(filename).getPath();
//            String[] columns = new String[]{"_id", "STATION_ID", "NAME", "WMO_ID", "BEGIN_DATE", "END_DATE", "LATITUDE", "LONGITUDE", "GAUSS1", "GAUSS2", "GEOGR1", "GEOGR2", "ELEVATION", "ELEVATION_PRESSURE"};
//            ResultSet resultSet = new Csv().read(path, columns, StandardCharsets.UTF_8.toString());
//            log.error(String.valueOf(resultSet.getMetaData().getColumnCount()));
//            log.error(String.valueOf(resultSet));
            repository.loadDataFromFile(null);
//            log.error(repository.read().toString());
        };
    }
}
