package com.kata.service.raoul.services;

import java.util.Date;
import java.util.List;

import com.kata.service.raoul.domain.Client;
import com.kata.service.raoul.domain.Operation;

public interface IServices {

	public void makeClientDeposit(Operation operation) throws Exception;
	
	public void makeClientWithdrawal(Operation operation) throws Exception;
	
	public List<Operation> getClientOperations(Long clientId, Date dateFrom, Date dateTo) throws Exception;
	
	public Client getClientInfo(Long clientId) throws Exception;
}
