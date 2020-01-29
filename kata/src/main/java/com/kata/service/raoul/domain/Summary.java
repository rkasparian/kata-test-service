package com.kata.service.raoul.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Summary implements Serializable
{
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	
	public Summary() 
	{
		
	}
	
	public Summary(Client client, List<Operation> operations) 
	{
		this.client = client;
		this.operations = operations;
		if(client!=null)
			this.totalBalance = client.getCurrentBalance();
	}
	
	public Summary(Client client, List<Operation> operations, long balance) 
	{
		this.client = client;
		this.operations = operations;
		this.balance = balance;
		if(client!=null)
			this.totalBalance = client.getCurrentBalance();
	}
	private Client client;
	
	private List<Operation> operations = new ArrayList<Operation>();
	
	private Long balance = 0L;
	
	private Long totalBalance = 0L;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Long totalBalance) {
		this.totalBalance = totalBalance;
	}

}
