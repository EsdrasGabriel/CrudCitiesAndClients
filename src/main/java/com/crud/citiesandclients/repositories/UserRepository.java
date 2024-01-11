package com.crud.citiesandclients.repositories;

import com.crud.citiesandclients.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
