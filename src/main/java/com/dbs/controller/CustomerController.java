package com.dbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.CustomerNotFoundException;
import com.dbs.model.Customer;
import com.dbs.service.CustomerService;
import com.dbs.service.Status;

@RestController
public class CustomerController {

	@Autowired
    CustomerService customerService;
    private Status status = new Status();
    
    @GetMapping("/customer/customerDetails/{customerId}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customerId") String customerId) throws CustomerNotFoundException {
    	
        Customer customer = customerService.getCustomerDetails(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    
    @GetMapping("/customer/allCustomerDetails")
    public ResponseEntity<List<Customer>> getAllCustomerData(){
    	
        List<Customer> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
        
    }
    
    
    @PostMapping("/customer/addNewCustomer")
    public ResponseEntity<Status> addNewCustomer(@RequestBody Customer newCustomer) {
    	
        status = customerService.AddNewCustomer(newCustomer);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }
    
    @PutMapping("/customer/updateBalance/{customerId}/{amount}")
    public ResponseEntity<Status> updateCustomerBalance(@PathVariable("customerId") String customerId, @PathVariable("amount") Double amount) {
    	
        status = customerService.updateBalance(customerId, amount);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }


}
