package com.dbs.exception;

public class CurrencyCodeNotFoundException  extends Exception{

    public CurrencyCodeNotFoundException() { 
    	super();
    }

    public CurrencyCodeNotFoundException(String exception) { 
    	super(exception); 
    }
    public CurrencyCodeNotFoundException(Exception exception) { 
    	super(exception); 
    }

}
