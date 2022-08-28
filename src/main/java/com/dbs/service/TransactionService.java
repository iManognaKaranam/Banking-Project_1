package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.exception.InvalidTransactionIdException;
import com.dbs.model.Transaction;
import com.dbs.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
    @Autowired
    CustomerService customerService;
    
    @Autowired
    CurrencyService currencyService;
    
    @Autowired
    TransferTypesService transferTypeService;
    
    private Status status=new Status();
    
    public Transaction getTransactionDetails(Long transactionId) throws InvalidTransactionIdException {
    	
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        if (transaction.isEmpty()) {
        	throw new InvalidTransactionIdException("Invalid Transaction Id");
        }
        
        else {
        	return transaction.get();
        }
    }
    
    public Transaction setTransactionDetails(Transaction transaction) {
    	
      try {
    	  
          Double conversionRate = currencyService.getConversionRate(transaction.getCurrency().getCurrenyCode());
          Double amount = transaction.getInrAmount();
          Double tax = (amount * conversionRate) * 0.0025;
          transaction.setTransferFees((Double)tax);
          Double totalAmount = (amount * conversionRate) + tax;
          Double clearBalance = customerService.getCustomerDetails(transaction.getCustomer().getCustomerId()).getClearBalance();
          Double totalClearBalance = clearBalance - totalAmount;
          transaction.getCustomer().setClearBalance((Double)totalClearBalance);
          customerService.updateBalance(transaction.getCustomer().getCustomerId(), (Double)totalClearBalance);
          transaction.getCustomer().setClearBalance((Double) totalClearBalance);
          transactionRepository.save(transaction);
          return transactionRepository.findById(transaction.getTransactionId()).get();
      } 
      
      catch (Exception e) {
          status.setMessage(" Transaction Unsuccessful");
          return null;
      }
      
    }

    		
    
	
}
