package com.crud.citiesandclients.domain.cities;

import jakarta.validation.constraints.NotBlank;

public record DataCityDTO(
        @NotBlank(message = "City is a required field")
        String name,
        @NotBlank(message = "State is a required field")
        String state
) {
}
