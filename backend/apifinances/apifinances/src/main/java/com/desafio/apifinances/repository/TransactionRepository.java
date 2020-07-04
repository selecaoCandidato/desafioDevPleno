package com.desafio.apifinances.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.apifinances.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	public Transaction findAllByAccountId(long account_id);
	
	@Query("select t from Transaction t where DATE(t.createdDate) = :date")
	public ArrayList<Transaction> findByDate(@Param("date") LocalDate date);
}
