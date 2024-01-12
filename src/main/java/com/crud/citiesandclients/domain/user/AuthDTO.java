package com.crud.citiesandclients.domain.user;

import jakarta.validation.constraints.NotBlank;

public record AuthDTO(
        @NotBlank(message = "Login is a required field")
        String login,
        @NotBlank(message = "Password is a required field")
        String password
) {
}
