package com.github.galuverior.citiesapi.cities.service;

import com.github.galuverior.citiesapi.cities.entities.City;
import com.github.galuverior.citiesapi.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getCitiesWithGeolocation() {

        List<City> cities = repository.findAll();
        cities.forEach(o->
                o.setLatLong(o.getLat() + "," + o.getLon())
        );

        return cities;

    }

    public Optional<City> getCityWithGeolocation(Long id) {

        Optional<City> city = repository.findById(id);
        city.get().setLatLong(city.get().getLat() + "," + city.get().getLon());
        return city;

    }

}
