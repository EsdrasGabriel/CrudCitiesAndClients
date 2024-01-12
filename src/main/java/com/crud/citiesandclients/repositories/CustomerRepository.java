package com.crud.citiesandclients.repositories;

import com.crud.citiesandclients.domain.clients.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
