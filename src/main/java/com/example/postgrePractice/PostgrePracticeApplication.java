package com.example.postgrePractice;

import com.example.postgrePractice.model.Customer;
import com.example.postgrePractice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class PostgrePracticeApplication {
	@Autowired
	private CustomerRepository repository;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		List allCustomers = this.repository.findAll();
		System.out.println("Number of customers: " + allCustomers.size());

		Customer newCustomer = new Customer();
		newCustomer.setFirstName("John");
		newCustomer.setLastName("Doe");
		System.out.println("Saving new customer...");
		this.repository.save(newCustomer);

		allCustomers = this.repository.findAll();
		System.out.println("Number of customers: " + allCustomers.size());
	}

	public static void main(String[] args) {
		SpringApplication.run(PostgrePracticeApplication.class, args);
	}

}
