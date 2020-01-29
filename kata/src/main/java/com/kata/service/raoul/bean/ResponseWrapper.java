package com.kata.service.raoul.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResponseWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResponseWrapper(Throwable t) 
	{
		this.timestamp = LocalDateTime.now();
		this.message = t.getLocalizedMessage();
	}

	public ResponseWrapper(Object obj) 
	{
		this.timestamp = LocalDateTime.now();
		this.value = obj;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	

    @JsonInclude(Include.NON_NULL)
	private String message;   

    @JsonInclude(Include.NON_NULL)
	private Object value;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

}
