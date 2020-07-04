package com.desafio.apifinances.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apifinances.models.Account;
import com.desafio.apifinances.repository.AccountRepository;

@RestController
@RequestMapping(value="/api")
public class AccountResource {

	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/account/{number}")
	public Account getExistingAccount(@PathVariable("number") int number) {
		Account account = accountRepository.findByNumber(number);
		return account;
	}
	
	
	@PostMapping("/account")
	public Object createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
}