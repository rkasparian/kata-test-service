package com.kata.service.raoul.services;

import java.util.Date;
import java.util.List;

import com.kata.service.raoul.domain.Client;
import com.kata.service.raoul.domain.Operation;

public class Services implements IServices{

	@Override
	public void makeClientDeposit(Operation operation) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeClientWithdrawal(Operation operation) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Operation> getClientOperations(Long clientId, Date dateFrom, Date dateTo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientInfo(Long clientId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
