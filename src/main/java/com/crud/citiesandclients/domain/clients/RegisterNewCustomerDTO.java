package com.crud.citiesandclients.domain.clients;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegisterNewCustomerDTO(
        @NotBlank(message = "Full Name is a required field")
        String fullName,
        @NotNull(message = "Gender is a required field")
        GenderEnum gender,
        @NotNull(message = "Date of Birth is a required field")
        LocalDate dateOfBirth,
        @NotNull(message = "Age is a required field")
        @Min(value = 18)
        Integer age,
        @NotNull(message = "City_id is a required field")
        Long city_id
) {
}
