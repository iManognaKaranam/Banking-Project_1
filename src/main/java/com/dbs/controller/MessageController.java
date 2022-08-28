package com.dbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.InvalidMessageCodeException;
import com.dbs.model.Message;
import com.dbs.service.MessageService;

@RestController
public class MessageController {

	@Autowired
    MessageService messageService;
	
    @GetMapping("messageDetails/{messageCode}")
    public ResponseEntity<Message> getMessageCodeDetails(@PathVariable("messageCode") String messageCode) throws InvalidMessageCodeException {
    	
        Message message = messageService.getMessageDetails(messageCode);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
