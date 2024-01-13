package com.crud.citiesandclients.services.city;

import com.crud.citiesandclients.domain.cities.City;
import com.crud.citiesandclients.domain.cities.RegisterNewCityDTO;

import java.util.List;

public interface CityServiceInterface {
    City registerNewCity(RegisterNewCityDTO city);
    List<City> findWithFilter(City filter);
}
