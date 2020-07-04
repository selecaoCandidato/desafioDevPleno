package com.desafio.apifinances.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/transaction/extract/{startDate}/{endDate}/{account}")
	public List<Transaction> getExtract(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate, @PathVariable("account") long account){
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		
		while (start.isBefore(end)) {
			ArrayList<Transaction> findedTransactions = transactionsRepository.findByDate(start);
		    start = start.plusDays(1);
		    
		    for (int i = 0; i < findedTransactions.size(); i++) {
		    	if (findedTransactions.get(i).getAccount().getId() == account) {
		    		transactions.add(findedTransactions.get(i));
		    	}
		    }
		}
		return transactions;
	}
	
	@PostMapping("/transaction/{id}/{number}")
	public Object createAccount(@RequestBody Transaction transaction, @PathVariable("id") long id, @PathVariable(required = false) int number) {
		Account account = accountRepository.findById(id);
		switch (transaction.getType()) {
		
			case "debit":
				Double atualBalance = account.getBalance();
				Double finalBalance = atualBalance + transaction.getValue();
				account.setBalance(finalBalance);
				accountRepository.save(account);
				transaction.setAccount(account);;
				transactionsRepository.save(transaction);
				return account;
				
			case "credit":
				if (account.getBalance() < transaction.getValue()) {
					return "Você não possui saldo suficiente para esta transação";
				}else {
					Double balance = account.getBalance();
					Double resultBalance = balance - transaction.getValue();
					account.setBalance(resultBalance);
					accountRepository.save(account);
					transaction.setAccount(account);;
					transactionsRepository.save(transaction);transactionsRepository.save(transaction);
					return account;
				}
				
			case "transfer":
				
				if (account.getBalance() < transaction.getValue()) {
					return "Você não possui saldo suficiente para esta transação";
				}else {
					Account transferAccount = accountRepository.findByNumber(number);
					
					if (transferAccount != null) {
						Double balance = account.getBalance();
						Double resultBalance = balance - transaction.getValue();
						account.setBalance(resultBalance);
						accountRepository.save(account);
						
						Double balanceTransfered = transferAccount.getBalance();
						Double resultBalanceTransfered = balanceTransfered + transaction.getValue();
						transferAccount.setBalance(resultBalanceTransfered);
						accountRepository.save(transferAccount);
						transaction.setAccount(account);;
						transactionsRepository.save(transaction);
						return transferAccount;
					}else {
						return "A conta destino não existe";
					}
					
				}
		}
		return "";
	}
}
