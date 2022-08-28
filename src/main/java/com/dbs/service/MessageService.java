package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.exception.InvalidMessageCodeException;
import com.dbs.model.Message;
import com.dbs.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	public Message getMessageDetails(String messageCode) throws InvalidMessageCodeException {
		
        Optional<Message> message = messageRepository.findById(messageCode);
        if (message.isEmpty()) {
        	throw new InvalidMessageCodeException("Invalid Message Code or Message Code Not Found");
        }
        return message.get();
      
    }

}
