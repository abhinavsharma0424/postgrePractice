package com.example.postgrePractice.services;

import com.example.postgrePractice.model.Customer;
import com.example.postgrePractice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> getAllCustomers =new ArrayList<>();
        System.out.println("Getting all customers");
        customerRepository.findAll().forEach(customer -> {
            System.out.println(customer);
            getAllCustomers.add(customer);
        });
        return getAllCustomers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        System.out.println("Fetching Customer");
        return customerRepository.findById(id).get();//to get from optional
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        System.out.println("Saving the Customer"+ customer);
        return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Customer cust=getCustomerById(id);
        System.out.println("Updating "+cust);
        cust.setFirstName(customer.getFirstName());
        cust.setLastName(customer.getLastName());
        customerRepository.save(cust);
    }

    @Override
    public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
    }
}
