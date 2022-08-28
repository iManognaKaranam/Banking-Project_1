package com.dbs.exception;

public class InvalidMessageCodeException extends Exception{

	public InvalidMessageCodeException() { 
    	super();
    }

    public InvalidMessageCodeException(String exception) { 
    	super(exception); 
    }
    public InvalidMessageCodeException(Exception exception) { 
    	super(exception); 
    }

}
