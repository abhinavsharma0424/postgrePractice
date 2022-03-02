package com.example.postgrePractice.controllers;

import com.example.postgrePractice.model.Customer;
import com.example.postgrePractice.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getAllCustomers()
    {
        System.out.println("Fetching..........");
       return customerService.getCustomers();

    }
    @GetMapping("/{id}")
     public Customer getCustomerById(@PathVariable Long id)
    {
        System.out.println("Get Customer By Id "+id );
           return customerService.getCustomerById(id);

    }

    @PostMapping()
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer)
    {
        System.out.println("update customer" +id);
         customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id)
    {
        customerService.deleteCustomer(id);
    }
}
