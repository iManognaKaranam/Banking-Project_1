package com.dbs.model;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency {
	
	@Id
	@Column(name="currencyCode")
	private String currenyCode;
	@Column(name="currencyName")
	private String currencyName;
	@Column(name="converisonRate")
	private Double conversionRate;
	
	public Currency() {
		// TODO Auto-generated constructor stub
	}

	public Currency(String currenyCode, String currencyName, Double conversionRate) {
		this.currenyCode = currenyCode;
		this.currencyName = currencyName;
		this.conversionRate = conversionRate;
	}

	public String getCurrenyCode() {
		return currenyCode;
	}

	public void setCurrenyCode(String currenyCode) {
		this.currenyCode = currenyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(Double conversionRate) {
		this.conversionRate = conversionRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conversionRate, currencyName, currenyCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		return Objects.equals(conversionRate, other.conversionRate) && Objects.equals(currencyName, other.currencyName)
				&& Objects.equals(currenyCode, other.currenyCode);
	}

	@Override
	public String toString() {
		return "Currency [currenyCode=" + currenyCode + ", currencyName=" + currencyName + ", conversionRate="
				+ conversionRate + "]";
	}
	

}
