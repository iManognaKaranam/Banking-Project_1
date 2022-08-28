package com.dbs.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.exception.CurrencyCodeNotFoundException;
import com.dbs.exception.CustomerNotFoundException;
import com.dbs.model.Currency;
import com.dbs.model.Customer;
import com.dbs.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CurrencyService currencyService;
	
	private Status status=new Status();
	
	public Customer getCustomerDetails(String id) throws CustomerNotFoundException {
        
		Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
        	throw new CustomerNotFoundException("Customer with Id doesn't exist");
        }
        else {
        	return customer.get();
        }
    }
	
	public List<Customer> findAllCustomers(){
		
        return customerRepository.findAll();
    }
	
	public Double updateCurrencyCodeValue(Customer customer, String currencyCode, Double amount) throws CurrencyCodeNotFoundException {
		
        Double balance = customer.getClearBalance();
        Currency currency = currencyService.getCurrencyDetails(currencyCode);
        balance *= currency.getConversionRate();
        customer.setClearBalance(balance);
        customerRepository.save(customer);
        return customer.getClearBalance();
        
    }

    public Status updateBalance(String customerId, Double clearBalance) {
    	
        Customer customer = customerRepository.findById(customerId).get();
        customer.setClearBalance(clearBalance);
        customerRepository.save(customer);
        status.setMessage("Successfully Updated");
        return status;
        
    }
    
    public Status AddNewCustomer(Customer newCustomer) {
    	
        try {
            if (!customerRepository.findById(newCustomer.getCustomerId()).isPresent()) {
            	
                customerRepository.save(newCustomer);
                status.setMessage("Added new Customer Successfully");
                return status;
            }

        } 
        
        catch (Exception e) {
            System.out.println("");
        }
        
        status.setMessage("Unsuccessful, Customer cannot be added");
        return status;
    }
	
}
