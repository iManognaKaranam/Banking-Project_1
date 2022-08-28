package com.dbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.BankNotFoundException;
import com.dbs.model.Bank;
import com.dbs.service.BankService;

@RestController
public class BankController {

	 @Autowired
	 BankService bankService;
	 
	 @GetMapping("/bankDetails/{bic}")
	 public ResponseEntity<Bank> getBankDetails(@PathVariable("bic") String bic) throws BankNotFoundException {
	        Bank bank = bankService.getBankDetails(bic);
	        return new ResponseEntity<>(bank, HttpStatus.OK);
	 }
}
