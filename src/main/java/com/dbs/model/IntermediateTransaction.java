package com.dbs.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IntermediateTransaction")
public class IntermediateTransaction {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private String customerId;
    private String receiverBIC;
    private String receiverAccountHolderNumber;
    private String receiverAccountHolderName;
    private String transferTypeCode;
    private String messageCode;
    private Double transferFees;
    private Double inrAmount;
    private Date transferDate;
    private String currencyCode;
    
    public IntermediateTransaction() { 
    	super(); 
    }
    
    public IntermediateTransaction(Long transactionId, String customerId, String receiverBIC, String receiverAccountHolderNumber, String receiverAccountHolderName, String transferTypeCode, String messageCode,Double transferFees, Double inrAmount, 
    		Date transferDate, String currencyCode) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.receiverBIC = receiverBIC;
        this.receiverAccountHolderNumber = receiverAccountHolderNumber;
        this.receiverAccountHolderName = receiverAccountHolderName;
        this.transferTypeCode = transferTypeCode;
        this.messageCode = messageCode;
        this.transferFees = transferFees;
        this.inrAmount = inrAmount;
        this.transferDate = transferDate;
        this.currencyCode = currencyCode;
    }
    
    public Long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getReceiverBIC() {
        return receiverBIC;
    }
    public void setReceiverBIC(String receiverBIC) {
        this.receiverBIC = receiverBIC;
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
    public String getTransferTypeCode() {
        return transferTypeCode;
    }
    public void setTransferTypeCode(String transferTypeCode) {
        this.transferTypeCode = transferTypeCode;
    }
    public String getMessageCode() {
        return messageCode;
    }
    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
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
    public String getCurrencyCode() { 
    	return currencyCode; 
    }
    public void setCurrencyCode(String currencyCode) { 
    	this.currencyCode = currencyCode; 
    }
}
