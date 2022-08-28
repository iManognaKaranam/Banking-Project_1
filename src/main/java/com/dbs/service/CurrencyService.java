package com.dbs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.exception.CurrencyCodeNotFoundException;
import com.dbs.model.Currency;
import com.dbs.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	public Currency getCurrencyDetails(String currencyCode) throws CurrencyCodeNotFoundException {
		
	        Optional<Currency> currency = currencyRepository.findById(currencyCode);
	        if (currency.isEmpty()) {
	        	throw new CurrencyCodeNotFoundException("Invalid Currency Code or Code Not Found");
	        }
	        else {
	        	return currency.get();
	        }
	    }
	
	public Double getConversionRate(String currencyCode) throws CurrencyCodeNotFoundException {
	    	
	        Optional<Currency> currency = currencyRepository.findById(currencyCode);
	        if (currency.isEmpty()) {
	        	throw new CurrencyCodeNotFoundException("Invalid Currency Code or Code Not Found");
	        }
	        else {
	        	return currency.get().getConversionRate();
	        }
	  	}
	
	public List<Currency> getAllCurrencyDetails() {
		
	        return currencyRepository.findAll();
	    }
}
