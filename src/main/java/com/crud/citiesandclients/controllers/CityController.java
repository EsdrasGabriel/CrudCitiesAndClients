package com.crud.citiesandclients.controllers;

import com.crud.citiesandclients.domain.cities.City;
import com.crud.citiesandclients.domain.cities.RegisterNewCityDTO;
import com.crud.citiesandclients.repositories.CityRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid RegisterNewCityDTO city, UriComponentsBuilder uriBuilder) {
        City save = cityRepository.save(new City(city));
        URI uri = uriBuilder.path("/city/{id}").buildAndExpand(save.getId()).toUri();

        return ResponseEntity.created(uri).body(save);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<City> findWithFilter(City filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<City> example = Example.of(filter, matcher);

        return cityRepository.findAll(example);
    }
}
