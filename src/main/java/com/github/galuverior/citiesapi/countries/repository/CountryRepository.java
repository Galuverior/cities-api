package com.github.galuverior.citiesapi.countries.repository;

import com.github.galuverior.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
