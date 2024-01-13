package com.crud.citiesandclients.services.city;

import com.crud.citiesandclients.domain.cities.City;
import com.crud.citiesandclients.domain.cities.RegisterNewCityDTO;
import com.crud.citiesandclients.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements CityServiceInterface {
    @Autowired
    private CityRepository  cityRepository;

    @Override
    public City registerNewCity(RegisterNewCityDTO city) {
        return cityRepository.save(new City(city));
    }

    @Override
    public List<City> findWithFilter(City filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<City> example = Example.of(filter, matcher);

        return cityRepository.findAll(example);
    }
}
