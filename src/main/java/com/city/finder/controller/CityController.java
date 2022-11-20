package com.city.finder.controller;

import com.city.finder.model.City;
import com.city.finder.service.CityService;
import java.io.Reader;
import java.nio.file.Files;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
@CrossOrigin(origins = "http://localhost:3000")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping()
    public List<City> getCities(String name) {
        return cityService.getCities(name);
    }

    @PostMapping()
    public City Save(City city){
        return cityService.Save(city);
    }

}
