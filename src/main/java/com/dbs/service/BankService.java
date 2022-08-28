package com.dbs.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.exception.BankNotFoundException;
import com.dbs.model.Bank;
import com.dbs.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;
	public Bank getBankDetails(String bic) throws BankNotFoundException{
		
		Optional<Bank> bank = bankRepository.findById(bic);
		if (bank.isEmpty()) {
			throw new BankNotFoundException("Invalid Bank Code");
		}
		else{
			return bank.get();
		}
		
	}
}
