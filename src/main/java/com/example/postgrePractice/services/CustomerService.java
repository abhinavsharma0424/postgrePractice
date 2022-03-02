package com.example.postgrePractice.services;

import com.example.postgrePractice.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomerById(Long  id);

    public Customer saveCustomer(Customer customer);

    public void updateCustomer(Long id, Customer customer);

    public void deleteCustomer(Long id);
}
