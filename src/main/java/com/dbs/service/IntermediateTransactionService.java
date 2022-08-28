package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.exception.BankNotFoundException;
import com.dbs.exception.CurrencyCodeNotFoundException;
import com.dbs.exception.CustomerNotFoundException;
import com.dbs.exception.InvalidMessageCodeException;
import com.dbs.exception.InvalidTransactionIdException;
import com.dbs.exception.TransferTypesNotFoundException;
import com.dbs.model.IntermediateTransaction;
import com.dbs.model.Transaction;
import com.dbs.repository.IntermediateTransactionRepository;

@Service
public class IntermediateTransactionService {
	
    @Autowired
    private IntermediateTransactionRepository intermediateTransactionRepository;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private BankService bankService;
    
    @Autowired
    private TransferTypesService transferTypesService;
    
    @Autowired
    private MessageService messageService;
    
    @Autowired
    CurrencyService currencyService;
    
    private final Status status = new Status();
    
    public Transaction getTransactionDetails(Long transactionId) throws InvalidTransactionIdException, CustomerNotFoundException, BankNotFoundException, CurrencyCodeNotFoundException, TransferTypesNotFoundException, InvalidMessageCodeException {
    	
        Optional<IntermediateTransaction> intermediateTransaction = intermediateTransactionRepository.findById(transactionId);
        if (intermediateTransaction.isEmpty()) {
        	throw new InvalidTransactionIdException("Invalid Transaction Id");
        }
        
        else {
        	
        	IntermediateTransaction intermediateTransaction1 = intermediateTransaction.get();
            Transaction transaction = new Transaction();
            transaction.setTransactionId(intermediateTransaction1.getTransactionId());
            transaction.setCustomer(customerService.getCustomerDetails(intermediateTransaction1.getCustomerId()));
            transaction.setCurrency(currencyService.getCurrencyDetails(intermediateTransaction1.getCurrencyCode()));
            transaction.setReceiverBank(bankService.getBankDetails(intermediateTransaction1.getReceiverBIC()));
            transaction.setReceiverAccountHolderNumber(intermediateTransaction1.getReceiverAccountHolderNumber());
            transaction.setReceiverAccountHolderName(intermediateTransaction1.getReceiverAccountHolderName());
            transaction.setTransferTypes(transferTypesService.getTransferTypeDetails(intermediateTransaction1.getTransferTypeCode()));
            transaction.setMessage(messageService.getMessageDetails(intermediateTransaction1.getMessageCode()));
            transaction.setTransferFees(intermediateTransaction1.getTransferFees());
            transaction.setInrAmount(intermediateTransaction1.getInrAmount());
            transaction.setTransferDate(intermediateTransaction1.getTransferDate());
            return transaction;
        }
    }
    
    public Status setTransactionDetails(IntermediateTransaction intermediateTransaction) {
        try {
            intermediateTransactionRepository.save(intermediateTransaction);
            status.setMessage("Transaction Successfully Inserted");
            return status;
        } 
        catch (Exception e) {
            status.setMessage("Transaction Unsuccessfull");
            return status;
        }
    }
}
