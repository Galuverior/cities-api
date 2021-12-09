package com.github.galuverior.citiesapi.states.entities;

import com.github.galuverior.citiesapi.countries.entities.Country;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")

public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String uf;

    @Column(name = "ibge")
    private Integer ibge;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Transient
    private List<Ddd> ddd;

    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public List<Ddd> getDdd() {
        return ddd;
    }

    public Country getCountry() {
        return country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setDdd(List<Ddd> ddd) {
        this.ddd = ddd;
    }

}
