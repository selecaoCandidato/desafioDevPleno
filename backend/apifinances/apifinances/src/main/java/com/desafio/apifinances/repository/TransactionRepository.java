package com.desafio.apifinances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apifinances.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
