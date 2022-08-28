package com.dbs.exception;

public class CustomerNotFoundException extends Exception{

	public CustomerNotFoundException() { 
    	super();
    }

    public CustomerNotFoundException(String exception) { 
    	super(exception); 
    }
    public CustomerNotFoundException(Exception exception) { 
    	super(exception); 
    }

}
