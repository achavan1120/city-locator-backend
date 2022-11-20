package com.city.finder.service;

import com.city.finder.model.City;
import com.city.finder.repository.CityRepository;
import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

  @Autowired
  private CityRepository cityRepository;

  private static String CITY_CSV_FILE_PATH = "cities.csv";

  public City Save(City city) {
    return cityRepository.save(city);
  }

  public void uploadCities() {
    List<City> cities = getCSVCities();
    cityRepository.saveAll(cities);
  }

  public List<City> getCities(String name) {
    if(name != null && !name.isEmpty()) {
      return cityRepository.findByNameContaining(name);
    }else {
      return cityRepository.findAll();
    }
  }

  @SneakyThrows
  public List<City> getCSVCities() {
    try (
        Reader reader = Files.newBufferedReader(
            Paths.get(ClassLoader.getSystemResource(CITY_CSV_FILE_PATH).toURI()));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
            .withFirstRecordAsHeader()
            .withIgnoreHeaderCase()
            .withTrim());
    ) {
      List<City> cities = new ArrayList<>();
      for (CSVRecord csvRecord : csvParser) {
        cities
            .add(
                new City(Integer.parseInt(csvRecord.get("id")),
                    csvRecord.get("name"), csvRecord.get("photo")));
      }
      return cities;
    }
  }

}
