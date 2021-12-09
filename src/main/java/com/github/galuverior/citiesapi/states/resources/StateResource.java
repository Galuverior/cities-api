package com.github.galuverior.citiesapi.states.resources;

import com.github.galuverior.citiesapi.states.entities.State;
import com.github.galuverior.citiesapi.states.service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateService stateService;

    public StateResource(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public List<State> states() {
        return stateService.findStates();

    }
}
