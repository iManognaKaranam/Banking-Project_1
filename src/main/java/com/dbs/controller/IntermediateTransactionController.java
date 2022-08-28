package com.dbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbs.exception.BankNotFoundException;
import com.dbs.exception.CurrencyCodeNotFoundException;
import com.dbs.exception.CustomerNotFoundException;
import com.dbs.exception.InvalidMessageCodeException;
import com.dbs.exception.InvalidTransactionIdException;
import com.dbs.exception.TransferTypesNotFoundException;
import com.dbs.model.IntermediateTransaction;
import com.dbs.model.Transaction;
import com.dbs.service.IntermediateTransactionService;
import com.dbs.service.Status;

@RestController
public class IntermediateTransactionController {

	@Autowired
    IntermediateTransactionService intermediateTransactionService;
	
    @GetMapping("/getTransactionDetails/{transactionId}")
    public ResponseEntity<Transaction> getTransactionDetails(@PathVariable("transactionId") Long transactionId) throws InvalidTransactionIdException, CustomerNotFoundException, BankNotFoundException, CurrencyCodeNotFoundException, TransferTypesNotFoundException, InvalidMessageCodeException {
        Transaction transaction = intermediateTransactionService.getTransactionDetails(transactionId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
    
    @PostMapping("/setTransactionDetails")
    public ResponseEntity<Status> setTransactionDetails(@RequestBody IntermediateTransaction intermediateTransaction) {
    	
        Status status = intermediateTransactionService.setTransactionDetails(intermediateTransaction);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
}
