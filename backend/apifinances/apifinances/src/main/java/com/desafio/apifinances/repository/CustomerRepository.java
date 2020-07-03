package com.desafio.apifinances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apifinances.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
