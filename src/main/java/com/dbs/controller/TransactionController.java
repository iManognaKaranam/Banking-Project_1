package com.dbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.InvalidTransactionIdException;
import com.dbs.model.Transaction;
import com.dbs.service.TransactionService;

@RestController
public class TransactionController {

	 @Autowired
	 TransactionService transactionService;

	 
	 @GetMapping("transactionDetails/{transactionId}")
	 public ResponseEntity<Transaction> getTransactionDetails(@PathVariable("transactionId") Long transactionId)
				throws InvalidTransactionIdException {
		 
			Transaction transaction = transactionService.getTransactionDetails(transactionId);
			return new ResponseEntity<>(transaction, HttpStatus.OK);
	 }

		
	@PostMapping("/addTransactionDetails")
	 public ResponseEntity<Long> setTransactionDetails(@RequestBody Transaction transaction) throws Exception {
		
			Transaction transaction1 = transactionService.setTransactionDetails(transaction);
			return new ResponseEntity<>(transaction1.getTransactionId(), HttpStatus.CREATED);
	 }
}
