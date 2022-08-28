package com.dbs.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
		@Id
		@Column(name="customerId")
		private String customerId;
		@Column(name="accountHolderName")
		private String accountHolderName;
		@Column(name="overDraftFlag")
		private Long overDraftFlag;
		@Column(name="clearBalance")
		private Double clearBalance;
		
		
		public Customer() {
			// TODO Auto-generated constructor stub
		}

		public Customer(String customerId, String accountHolderName, Long overDraftFlag, Double clearBalance,
				String customerAddress, String customerCity, String customerType) {
			this.customerId = customerId;
			this.accountHolderName = accountHolderName;
			this.overDraftFlag = overDraftFlag;
			this.clearBalance = clearBalance;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getAccountHolderName() {
			return accountHolderName;
		}

		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}

		public Long getOverDraftFlag() {
			return overDraftFlag;
		}

		public void setOverDraftFlag(Long overDraftFlag) {
			this.overDraftFlag = overDraftFlag;
		}

		public Double getClearBalance() {
			return clearBalance;
		}

		public void setClearBalance(Double clearBalance) {
			this.clearBalance = clearBalance;
		}

		@Override
		public int hashCode() {
			return Objects.hash(accountHolderName,clearBalance, customerId,overDraftFlag);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			return Objects.equals(accountHolderName, other.accountHolderName)
					&& Objects.equals(clearBalance, other.clearBalance)
					&& Objects.equals(customerId, other.customerId)
					&& Objects.equals(overDraftFlag, other.overDraftFlag);
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", accountHolderName=" + accountHolderName
					+ ", overDraftFlag=" + overDraftFlag + ", clearBalance=" + clearBalance + "]";
		}
		
		
		
}
