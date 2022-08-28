package com.dbs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customerUser")
public class CustomerUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	private Long userId;
	
	@Column(name="userName")
	//if login with userName then make it unique
	private String userName;
	
	@OneToOne
	@JoinColumn(name="customer")
	private Customer customer;
	
	@Column(name="userPassword")
	private String userPassword;
	

}
