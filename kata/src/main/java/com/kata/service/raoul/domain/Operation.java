package com.kata.service.raoul.domain;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable
{
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	
	public Operation() {
		
	}
	
	public Operation(OperationType operationType, Client client, Long amount, Date date)
	{
		this.operationType = operationType;
		this.client = client;
		this.amount = amount;
		this.date = date;
	}
	
	private Client client;
	
	private OperationType operationType;
	
	private Long amount = 0L;
	
	private Date date;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
