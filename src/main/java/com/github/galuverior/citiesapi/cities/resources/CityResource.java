package com.github.galuverior.citiesapi.cities.resources;

import com.github.galuverior.citiesapi.cities.entities.City;
import com.github.galuverior.citiesapi.cities.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityResource {


    private final CityService service;

    public CityResource(CityService service) {
        this.service = service;
    }

    @GetMapping
    public List<City> cities() {
        return service.getCitiesWithGeolocation();
    }

    @GetMapping("/{id}")
    public ResponseEntity <City> city(@PathVariable Long id) {
        Optional<City> optional = service.getCityWithGeolocation(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
