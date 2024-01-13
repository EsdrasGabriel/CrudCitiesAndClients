package com.crud.citiesandclients.services.customer;

import com.crud.citiesandclients.domain.clients.Customer;
import com.crud.citiesandclients.domain.clients.RegisterNewCustomerDTO;
import com.crud.citiesandclients.domain.clients.UpdateCustomerDTO;

import java.util.List;

public interface CustomerServiceInterface {
    Customer registerNewCustomer(RegisterNewCustomerDTO data);
    List<Customer> findWithFilter(Customer filter);
    void deleteById(Long id);
    void updateNameById(Long id, UpdateCustomerDTO data);
}
