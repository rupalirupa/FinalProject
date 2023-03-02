package com.cjc.exception;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}
}
