package com.crud.citiesandclients.repositories;

import com.crud.citiesandclients.domain.entity.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
