package com.dbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.TransferTypesNotFoundException;
import com.dbs.model.TransferTypes;
import com.dbs.service.TransferTypesService;

@RestController
public class TransferTypesController {

	@Autowired
    TransferTypesService transferTypesService;
	@GetMapping("/transferTypesDetails/{transferTypesCode}")
	public ResponseEntity<TransferTypes> getTransferTypeDetails(@PathVariable("transferTypesCode") String transferTypeCode) throws TransferTypesNotFoundException {
		
	        TransferTypes transferType = transferTypesService.getTransferTypeDetails(transferTypeCode);
	        return new ResponseEntity<>(transferType, HttpStatus.OK);
	 }

}
