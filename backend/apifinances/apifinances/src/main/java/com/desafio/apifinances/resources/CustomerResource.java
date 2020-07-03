package com.desafio.apifinances.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apifinances.models.Customer;
import com.desafio.apifinances.repository.CustomerRepository;

@RestController
@RequestMapping(value="/api")
public class CustomerResource {
	@Autowired
	CustomerRepository customerReposiory;
	
	@PostMapping("/customer")
	public Customer createAccount(@RequestBody Customer customer) {
		return customerReposiory.save(customer);
	}
}
