package com.dbs.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logger")
public class Logger {
	
	@Id
	@Column(name="loggerId")
	private Long loggerId;
	
	@Column(name="customerId")
	private String customerId;
	
	@Column(name="userId")
	private Long userId;
	
	@Column(name="employeeId")
	private Long employeeId;
	
	@Column(name="screenName")
	private String screenName;
	
	@Column(name="action")
	private String action;
	
	@Column(name="ipAddress")
	private String ipAddress;

	public Logger() {
		// TODO Auto-generated constructor stub
	}

	public Logger(Long loggerId, String customerId, Long userId, Long employeeId, String screenName, String action,
			String ipAddress) {
		this.loggerId = loggerId;
		this.customerId = customerId;
		this.userId = userId;
		this.employeeId = employeeId;
		this.screenName = screenName;
		this.action = action;
		this.ipAddress = ipAddress;
	}

	public Long getLoggerId() {
		return loggerId;
	}

	public void setLoggerId(Long loggerId) {
		this.loggerId = loggerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(action, customerId, employeeId, ipAddress, loggerId, screenName, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logger other = (Logger) obj;
		return Objects.equals(action, other.action) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(ipAddress, other.ipAddress)
				&& Objects.equals(loggerId, other.loggerId) && Objects.equals(screenName, other.screenName)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Logger [loggerId=" + loggerId + ", customerId=" + customerId + ", userId=" + userId + ", employeeId="
				+ employeeId + ", screenName=" + screenName + ", action=" + action + ", ipAddress=" + ipAddress + "]";
	}
	
	
}
