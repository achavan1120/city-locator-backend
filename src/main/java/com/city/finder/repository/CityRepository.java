package com.city.finder.repository;

import com.city.finder.model.City;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {
  List<City> findByNameContainingIgnoreCase(String name);
}
