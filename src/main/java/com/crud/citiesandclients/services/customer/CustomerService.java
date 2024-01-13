package com.crud.citiesandclients.services.customer;

import com.crud.citiesandclients.domain.cities.City;
import com.crud.citiesandclients.domain.clients.Customer;
import com.crud.citiesandclients.domain.clients.RegisterNewCustomerDTO;
import com.crud.citiesandclients.domain.clients.UpdateCustomerDTO;
import com.crud.citiesandclients.repositories.CityRepository;
import com.crud.citiesandclients.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Customer registerNewCustomer(RegisterNewCustomerDTO data) {
        City city = cityRepository
                .findById(data.city_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No cities found with this record"));

        Customer clientToSave = Customer.builder()
                .fullName(data.fullName())
                .gender(data.gender())
                .dateOfBirth(data.dateOfBirth())
                .age(data.age())
                .build();
        City cityToSave = City.builder()
                .id(city.getId())
                .build();
        clientToSave.setCity_id(cityToSave);

        return customerRepository.save(clientToSave);
    }

    @Override
    public List<Customer> findWithFilter(Customer filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Customer> example = Example.of(filter, matcher);

        return customerRepository.findAll(example);
    }

    @Override
    public void deleteById(Long id) {
        City city = cityRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Records Found"));
        customerRepository.deleteById(city.getId());
    }

    @Override
    public void updateNameById(Long id, UpdateCustomerDTO data) {
        Customer referenceById = customerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Records Found"));
        referenceById.setFullName(data.fullName());

        customerRepository.save(referenceById);
    }

}
