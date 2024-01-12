package com.crud.citiesandclients.controllers;

import com.crud.citiesandclients.domain.cities.City;
import com.crud.citiesandclients.domain.clients.Customer;
import com.crud.citiesandclients.domain.clients.RegisterNewCustomerDTO;
import com.crud.citiesandclients.domain.clients.UpdateCustomerDTO;
import com.crud.citiesandclients.repositories.CityRepository;
import com.crud.citiesandclients.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CityRepository cityRepository;

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid RegisterNewCustomerDTO client, UriComponentsBuilder uriBuilder) {
        City city = cityRepository
                .findById(client.city_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No cities found with this record"));

        Customer clientToSave = Customer.builder()
                .fullName(client.fullName())
                .gender(client.gender())
                .dateOfBirth(client.dateOfBirth())
                .age(client.age())
                .build();
        City cityToSave = City.builder()
                .id(city.getId())
                .build();
        clientToSave.setCity_id(cityToSave);

        Customer save = customerRepository.save(clientToSave);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(save.getId()).toUri();

        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findWithFilter(Customer filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Customer> example = Example.of(filter, matcher);

        return customerRepository.findAll(example);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deleteById(@PathVariable Long id) {
        City city = cityRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Records Found"));
        customerRepository.deleteById(city.getId());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity updateNameById(@PathVariable Long id, @RequestBody UpdateCustomerDTO data) {
        Customer referenceById = customerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Records Found"));
        referenceById.setFullName(data.fullName());

        customerRepository.save(referenceById);

        return ResponseEntity.noContent().build();
    }
}
