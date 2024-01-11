package com.crud.citiesandclients.controllers;

import com.crud.citiesandclients.domain.cities.City;
import com.crud.citiesandclients.domain.cities.RegisterCityDTO;
import com.crud.citiesandclients.repositories.CityRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid RegisterCityDTO city, UriComponentsBuilder uriBuilder) {
        System.out.println(city);
        City save = cityRepository.save(new City(city));
        URI uri = uriBuilder.path("/city/{id}").buildAndExpand(save.getId()).toUri();

        return ResponseEntity.created(uri).body(save);
    }
}
