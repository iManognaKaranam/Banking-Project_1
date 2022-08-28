package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.exception.TransferTypesNotFoundException;
import com.dbs.model.TransferTypes;
import com.dbs.repository.TransferTypesRepository;

@Service
public class TransferTypesService {
	
	@Autowired
	TransferTypesRepository transferTypesRepository;
	
	public TransferTypes getTransferTypeDetails(String transferTypeCode) throws TransferTypesNotFoundException {
		
        Optional<TransferTypes> transferType = transferTypesRepository.findById(transferTypeCode);
        if (transferType.isEmpty()) {
        	throw new TransferTypesNotFoundException("Invalid Transfer Type");
        }
        return transferType.get();
    }

	
	

}
