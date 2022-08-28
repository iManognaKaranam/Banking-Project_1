package com.dbs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.CurrencyCodeNotFoundException;
import com.dbs.model.Currency;
import com.dbs.service.CurrencyService;

@RestController
public class CurrencyController {

	@Autowired
    CurrencyService currencyService;
	
	@GetMapping("/currencyDetails/{currencyCode}")
	public ResponseEntity<Currency> currency(@PathVariable("currencyCode") String currencyCode) throws CurrencyCodeNotFoundException {
	        
		Currency currency = currencyService.getCurrencyDetails(currencyCode);
	    return new ResponseEntity<>(currency, HttpStatus.OK);
	}
	
	@GetMapping("/currencyDetails/")
    public ResponseEntity<List<Currency>> allCurrency() {
		
        List<Currency> messageCodes = currencyService.getAllCurrencyDetails();
        return new ResponseEntity<>(messageCodes, HttpStatus.OK);
    }

	@GetMapping("/conversionRate/{currencyCode}")
	public ResponseEntity<Double> getConversionRate(@PathVariable("currencyCode") String currencyCode) throws CurrencyCodeNotFoundException {
		
	        Double conversionRate = currencyService.getConversionRate(currencyCode);
	        return new ResponseEntity<>(conversionRate,HttpStatus.OK);
	}
	
	
}
