package com.dbs.exception;

public class InvalidTransactionIdException extends Exception{

	public InvalidTransactionIdException() { 
    	super();
    }

    public InvalidTransactionIdException(String exception) { 
    	super(exception); 
    }
    public InvalidTransactionIdException(Exception exception) { 
    	super(exception); 
    }
}
