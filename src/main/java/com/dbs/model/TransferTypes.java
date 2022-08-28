package com.dbs.model;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transferTypes")
public class TransferTypes {
	
	@Id
	@Column(name="transferTypeCode")
	private String transferTypeCode;
	@Column(name="transferTypeDescription")
	private String transferTypeDescription;
	
	public TransferTypes() {
		// TODO Auto-generated constructor stub
	}

	public TransferTypes(String transferTypeCode, String transferTypeDescription) {
		this.transferTypeCode = transferTypeCode;
		this.transferTypeDescription = transferTypeDescription;
	}

	public String getTransferTypeCode() {
		return transferTypeCode;
	}

	public void setTransferTypeCode(String transferTypeCode) {
		this.transferTypeCode = transferTypeCode;
	}

	public String getTransferTypeDescription() {
		return transferTypeDescription;
	}

	public void setTransferTypeDescription(String transferTypeDescription) {
		this.transferTypeDescription = transferTypeDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(transferTypeCode, transferTypeDescription);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferTypes other = (TransferTypes) obj;
		return Objects.equals(transferTypeCode, other.transferTypeCode)
				&& Objects.equals(transferTypeDescription, other.transferTypeDescription);
	}

	@Override
	public String toString() {
		return "TransferTypes [transferTypeCode=" + transferTypeCode + ", transferTypeDescription="
				+ transferTypeDescription + "]";
	}
	
	
	
}
