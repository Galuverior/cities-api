package com.github.galuverior.citiesapi.states.service;

import com.github.galuverior.citiesapi.states.entities.Ddd;
import com.github.galuverior.citiesapi.states.entities.State;
import com.github.galuverior.citiesapi.states.repository.DddRepository;
import com.github.galuverior.citiesapi.states.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    private final DddRepository dddRepository;

    public StateService(final StateRepository stateRepository, final DddRepository dddRepository) {
        this.stateRepository = stateRepository;
        this.dddRepository = dddRepository;
    }

    public List<State> findStates(){

        List<Ddd> ddds;
        List<State> state = stateRepository.findStatesWithDdd();
        state.forEach(o->
                o.setDdd(dddRepository.findAllDddByStateId(o.getId()))
        );

        return state;

    }

}
