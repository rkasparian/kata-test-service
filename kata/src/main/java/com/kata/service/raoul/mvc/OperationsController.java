package com.kata.service.raoul.mvc;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kata.service.raoul.bean.ResponseWrapper;
import com.kata.service.raoul.domain.Client;
import com.kata.service.raoul.domain.Operation;
import com.kata.service.raoul.domain.OperationType;
import com.kata.service.raoul.domain.Summary;
import com.kata.service.raoul.services.IServices;

@RestController("/")
public class OperationsController {

	@Autowired
	protected IServices services;
	
	protected static Log LOG = LogFactory.getLog(OperationsController.class.getName());
	
	public OperationsController() 
	{
		
	}
	
	@PostMapping("/clientDeposit")
	public ResponseEntity<ResponseWrapper> makeClientDeposit(@RequestParam(name="clientId", required = true) long clientId, @RequestParam(name="amount", required = true) long amount, @RequestParam(name="date", required = true) Date date)
	{
		try {
			services.makeClientDeposit(new Operation(new OperationType(OperationType.DEPOSIT), new Client(clientId), amount, date));
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseWrapper>(HttpStatus.OK);
	}

	@PostMapping("/clientWithdrawal")
	public ResponseEntity<ResponseWrapper> makeClientWithdrawal(@RequestParam(name="clientId", required = true) long clientId, @RequestParam(name="amount", required = true) long amount, @RequestParam(name="date", required = true) Date date)
	{
		try {
			services.makeClientWithdrawal(new Operation(new OperationType(OperationType.WITHDRAWAL), new Client(clientId), amount, date));
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ResponseWrapper>(HttpStatus.OK);
	}

	@PostMapping("/clientChecking")
	public ResponseEntity<ResponseWrapper> makeClientChecking(@RequestParam(name="clientId", required = true) long clientId, @RequestParam(name="dateFrom", required = false) Date dateFrom, @RequestParam(name="dateTo", required = false) Date dateTo)
	{
		Summary summary = null;
		try {
			Client client = services.getClientInfo(clientId);
			List<Operation> clientOperations = services.getClientOperations(clientId, dateFrom, dateTo);
			long balance = 0L;
			if(!CollectionUtils.isEmpty(clientOperations))
			{
				for (Operation operation : clientOperations)
				{
					int operationTypeId = operation.getOperationType().getId();
					Long operationAmount = operation.getAmount();
					
					if(operationTypeId==OperationType.DEPOSIT)
						balance += operationAmount;
					else if(operationTypeId==OperationType.WITHDRAWAL)
						balance -= operationAmount;
				}
			}
			summary = new Summary(client, clientOperations, balance);
		} catch (Exception e) {
			//log exception here
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			LOG.error(localizedMessage);
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(e), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(summary), HttpStatus.OK);
	}
}
