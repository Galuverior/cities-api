package com.github.galuverior.citiesapi.cities.repository;

import com.github.galuverior.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}
