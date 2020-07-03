package com.desafio.apifinances.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apifinances.models.Account;
import com.desafio.apifinances.repository.AccountRepository;
import com.desafio.apifinances.repository.CustomerRepository;

@RestController
@RequestMapping(value="/api")
public class AccountResource {

	@Autowired
	AccountRepository accountRepository;
	CustomerRepository customerReposiory;
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
}
