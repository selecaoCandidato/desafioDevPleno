package com.desafio.apifinances.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer responsible;
	
	private Double number;
	
	private Double balance;
	
	@ManyToOne
	private List<Transaction> transactions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getResponsible() {
		return responsible;
	}

	public void setResponsible(Customer responsible) {
		this.responsible = responsible;
	}	
	
}
