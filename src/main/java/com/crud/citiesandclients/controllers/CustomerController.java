package com.crud.citiesandclients.controllers;

import com.crud.citiesandclients.domain.clients.Customer;
import com.crud.citiesandclients.domain.clients.RegisterNewCustomerDTO;
import com.crud.citiesandclients.domain.clients.UpdateCustomerDTO;
import com.crud.citiesandclients.services.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid RegisterNewCustomerDTO client, UriComponentsBuilder uriBuilder) {
        Customer save = customerService.registerNewCustomer(client);
        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    public List<Customer> findWithFilter(Customer filter) {
        return customerService.findWithFilter(filter);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateNameById(@PathVariable Long id, @RequestBody UpdateCustomerDTO data) {
        customerService.updateNameById(id, data);
        return ResponseEntity.noContent().build();
    }
}
