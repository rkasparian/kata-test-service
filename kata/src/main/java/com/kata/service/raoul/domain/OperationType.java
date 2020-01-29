package com.kata.service.raoul.domain;

import java.io.Serializable;

public class OperationType implements Serializable {

	public static final int DEPOSIT = 1;
	public static final int WITHDRAWAL = 2;
	public static final int CHECKING = 3;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OperationType(int operationType)
	{
		this.id = operationType;
	}

	private int id;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	   
}
