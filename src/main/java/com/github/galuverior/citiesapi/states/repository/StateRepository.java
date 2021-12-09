package com.github.galuverior.citiesapi.states.repository;

import com.github.galuverior.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    @Query("SELECT s FROM State s INNER JOIN Ddd d on d.id_estado = s.id")
    List<State> findStatesWithDdd();

}
