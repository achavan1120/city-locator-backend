package com.city.finder.repository;

import com.city.finder.model.City;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
  List<City> findByName(String name);
  List<City> findByNameContaining(String name);
}
