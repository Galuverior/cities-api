package com.github.galuverior.citiesapi.states.repository;

import com.github.galuverior.citiesapi.states.entities.Ddd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DddRepository extends JpaRepository<Ddd, Long> {

        @Query("SELECT d FROM Ddd d WHERE d.id_estado = ?1")
        List<Ddd> findAllDddByStateId(Long id);

}
