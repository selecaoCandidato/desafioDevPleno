package com.desafio.apifinances.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apifinances.models.Account;
import com.desafio.apifinances.repository.AccountRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="Desafio API REST")
@CrossOrigin(origins="*")
public class AccountResource {

	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/account/{number}")
	@ApiOperation(value="Encontra uma conta já criada anteriormente")
	public Account getExistingAccount(@PathVariable("number") int number) {
		Account account = accountRepository.findByNumber(number);
		return account;
	}
	
	
	@PostMapping("/account")
	@ApiOperation(value="Cria uma nova conta bancária")
	public Object createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
}
