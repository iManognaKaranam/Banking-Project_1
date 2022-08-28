package com.dbs.model;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@Column(name="messageCode")
	private String messageCode;
	@Column(name="instruction")
	private String instruction;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String messageCode, String instruction) {
		this.messageCode = messageCode;
		this.instruction = instruction;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(instruction, messageCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(instruction, other.instruction) && Objects.equals(messageCode, other.messageCode);
	}

	@Override
	public String toString() {
		return "Message [messageCode=" + messageCode + ", instruction=" + instruction + "]";
	}
	

}
