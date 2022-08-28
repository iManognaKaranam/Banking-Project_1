package com.dbs.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="employeeId")
	private Long employeeId;
	@Column(name="employeeName")
	private String employeeName;
	@Column(name="employeePassword")
	private String employeePassword;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long employeeId, String employeeName, String employeePassword) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, employeeName, employeePassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeePassword, other.employeePassword);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + "]";
	}

	
}
