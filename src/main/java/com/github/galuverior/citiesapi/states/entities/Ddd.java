package com.github.galuverior.citiesapi.states.entities;

import javax.persistence.*;

@Table
@Entity
public class Ddd {

    @Column
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long id_estado;

    @Column
    private long ddd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_estado() {
        return id_estado;
    }

    public void setId_estado(long id_estado) {
        this.id_estado = id_estado;
    }

    public long getDdd() {
        return ddd;
    }

    public void setDdd(long ddd) {
        this.ddd = ddd;
    }
}
