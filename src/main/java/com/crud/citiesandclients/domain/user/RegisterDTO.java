package com.crud.citiesandclients.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank(message = "Login is a required field")
        String login,
        @NotBlank(message = "Password is a required field")
        String password,
        @NotNull(message = "Role is a required field")
        UserRole role
) {
}
