package com.dbs.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	
	@Id
	@Column(name="bic")
	private String bic;
	@Column(name="bankName")
	private String bankName;

	public Bank() {
		
	}

	public Bank(String bic, String bankName) {
		this.bic = bic;
		this.bankName = bankName;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankName, bic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(bankName, other.bankName) && Objects.equals(bic, other.bic);
	}

	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", bankName=" + bankName + "]";
	}
	
}
