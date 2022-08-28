package com.dbs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//didnt create hash code and to string

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transactionId")
	private Long transactionId;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="currency")
	private Currency currency;
	
	@ManyToOne
	@JoinColumn(name="bank")
	private Bank bank;
	
	@Column(name="receiverAccountHolderNumber")
	private String receiverAccountHolderNumber;
	@Column(name="receiverAccountHolderName")
	private String receiverAccountHolderName;
	
	@ManyToOne
	@JoinColumn(name="transferTypes")
	private TransferTypes transferTypes;
	
	@ManyToOne
	@JoinColumn(name="message")
	private Message message;
	
	@Column(name="currencyAmount")
	private Double currencyAmount;
	
	@Column(name="transferFees")
	private Double transferFees;
	
	@Column(name="inrAmount")
	private Double inrAmount;
	
	@Column(name="transferDate")
	private Date transferDate;
	
	@Column(name="status")
	private boolean status;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long transactionId, String receiverAccountHolderNumber, String receiverAccountHolderName,
			Double currencyAmount, Double transferFees, Double inrAmount, Date transferDate,boolean status) {
		this.transactionId = transactionId;
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
		this.receiverAccountHolderName = receiverAccountHolderName;
		this.currencyAmount = currencyAmount;
		this.transferFees = transferFees;
		this.inrAmount = inrAmount;
		this.transferDate = transferDate;
		this.status = status;
		
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getReceiverAccountHolderNumber() {
		return receiverAccountHolderNumber;
	}

	public void setReceiverAccountHolderNumber(String receiverAccountHolderNumber) {
		this.receiverAccountHolderNumber = receiverAccountHolderNumber;
	}

	public String getReceiverAccountHolderName() {
		return receiverAccountHolderName;
	}

	public void setReceiverAccountHolderName(String receiverAccountHolderName) {
		this.receiverAccountHolderName = receiverAccountHolderName;
	}
	
	public Bank getReceiverBank() {
        return bank;
    }
	
    public void setReceiverBank(Bank bank) {
        this.bank = bank;
    }
    
	public Double getCurrencyAmount() {
		return currencyAmount;
	}

	public void setCurrencyAmount(Double currencyAmount) {
		this.currencyAmount = currencyAmount;
	}

	public Double getTransferFees() {
		return transferFees;
	}

	public void setTransferFees(Double transferFees) {
		this.transferFees = transferFees;
	}

	public Double getInrAmount() {
		return inrAmount;
	}

	public void setInrAmount(Double inrAmount) {
		this.inrAmount = inrAmount;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public TransferTypes getTransferTypes() {
		return transferTypes;
	}

	public void setTransferTypes(TransferTypes transferTypes) {
		this.transferTypes = transferTypes;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
