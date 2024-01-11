package com.crud.citiesandclients.repositories;

import com.crud.citiesandclients.domain.entity.cities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
