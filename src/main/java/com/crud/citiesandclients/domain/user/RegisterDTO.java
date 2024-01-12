package com.crud.citiesandclients.domain.user;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
