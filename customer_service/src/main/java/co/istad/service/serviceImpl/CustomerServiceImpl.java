package co.istad.service.serviceImpl;


import co.istad.model.Customer;
import co.istad.model.request.CustomerRequest;
import co.istad.repository.CustomerRepository;
import co.istad.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("customer not found !!")
        );
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer =  customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("customer not found!!")
        );

        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("customer not found!!")
        );
        customerRepository.delete(customer);
    }


}
