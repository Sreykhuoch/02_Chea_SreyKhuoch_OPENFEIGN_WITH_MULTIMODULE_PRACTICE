package co.istad.service;

import co.istad.model.Customer;
import co.istad.model.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerRequest customerRequest);

    List<Customer> getAllCustomer();

    Customer getCustomer(Long id);

    Customer updateCustomer(Long id, CustomerRequest customerRequest);

    void deleteCustomer(Long id);
}
