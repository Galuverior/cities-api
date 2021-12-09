package com.github.galuverior.citiesapi.cities.entities;

import javax.persistence.*;

@Entity(name = "City")
@Table(name = "cidade")
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name="uf")
    private Integer uf;

    @Column(name = "ibge")
    private Integer ibge;

    @Column(name = "latitude")
    private String lat;

    @Column(name = "longitude")
    private String lon;

    @Transient
    private String latLong;

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public City() {
    }

}
