package com.desafio.apifinances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apifinances.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	public Account findById(long id);
	public Account findByNumber(int number);
}
