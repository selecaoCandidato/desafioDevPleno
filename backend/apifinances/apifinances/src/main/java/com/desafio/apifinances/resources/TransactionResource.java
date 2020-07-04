package com.desafio.apifinances.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apifinances.models.Account;
import com.desafio.apifinances.models.Transaction;
import com.desafio.apifinances.repository.AccountRepository;
import com.desafio.apifinances.repository.TransactionRepository;

@RestController
@RequestMapping(value="/api")
public class TransactionResource {
	
	@Autowired
	TransactionRepository transactionsRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@PostMapping("/transaction/{id}")
	public Transaction createAccount(@RequestBody Transaction transaction, @PathVariable("id") long id) {
		Account account = accountRepository.findById(id);
		transaction.setAccount(account);
		System.out.print(account);
		return transactionsRepository.save(transaction);
	}
}
