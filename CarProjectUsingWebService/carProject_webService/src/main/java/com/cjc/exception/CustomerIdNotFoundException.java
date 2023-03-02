package com.cjc.exception;

public class CustomerIdNotFoundException extends RuntimeException{

	public CustomerIdNotFoundException(String msg)
	{
		super(msg);
	}
}
