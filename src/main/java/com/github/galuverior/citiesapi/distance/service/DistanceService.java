package com.github.galuverior.citiesapi.distance.service;

import com.github.galuverior.citiesapi.cities.entities.City;
import com.github.galuverior.citiesapi.cities.repository.CityRepository;
import com.github.galuverior.citiesapi.utils.StringLocationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceUsingMath(final Long city1, final Long city2, final EarthRadius unit) {
        log.info("distanceUsingMath({}, {}, {})", city1, city2, unit);
        List<Double[]> locations = getLocationByCitiesIds(city1,city2);

        return doCalculation(locations.get(0)[0], locations.get(0)[1], locations.get(1)[0], locations.get(1)[1], unit);
    }

    public Double distanceUsingDoDistance(final Long city1, final Long city2, final EarthRadius unit) {
        log.info("distanceUsingDoDistance({}, {}, {})", city1, city2, unit);
        List<Double[]> locations = getLocationByCitiesIds(city1,city2);

        return doDistance(locations.get(0)[0], locations.get(0)[1], locations.get(1)[0], locations.get(1)[1], unit);
    }

    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        log.info("DistanceByPointsInMiles({}, {})", city1, city2);
        return distanceUsingDoDistance(city1,city2,EarthRadius.MILES);
    }

    public Double distanceUsingPoints(final Long city1, final Long city2, final EarthRadius unit) {
        log.info("distanceUsingPoints({}, {}, {})", city1, city2, unit);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = new Point(Double.valueOf(cities.get(0).getLat()),Double.valueOf(cities.get(0).getLon()));
        Point p2 = new Point(Double.valueOf(cities.get(1).getLat()),Double.valueOf(cities.get(1).getLon()));

        return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), unit);
    }

    private double doCalculation(final double lat1, final double lon1, final double lat2,
                                 final double lng2, final EarthRadius earthRadius) {
        double lat = toRadians(lat2 - lat1);
        double lon = toRadians(lng2 - lon1);
        double a = sin(lat / 2) * sin(lat / 2) +
                cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return earthRadius.getValue() * c;
    }

    private double doDistance(final double lat1, final double lon1, final double lat2,
                                 final double lng2, final EarthRadius earthRadius) {
        double acos = acos(cos(toRadians(lat1)) * cos(toRadians(lat2)) * cos(toRadians(lng2) - toRadians(lon1)) + sin(toRadians(lat1)) * sin(toRadians(lat2)));

        return earthRadius.getValue() * acos;
    }

    private List<Double[]> getLocationByCitiesIds(Long city1, Long city2) {

        final List<Double[]> locations = new ArrayList<>();

        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));
        cities.forEach(o-> {
            o.setLatLong(o.getLat() + "," + o.getLon());
            locations.add(StringLocationUtils.transform(o.getLatLong()));
        });

        return locations;
    }
}

