package com.dbs.exception;

public class BankNotFoundException extends Exception{
	public BankNotFoundException() { 
		super(); 
	}
    public BankNotFoundException(String exception) { 
    	super(exception); 
    }
    public BankNotFoundException(Exception exception) { 
    	super(exception); 
    }

}
