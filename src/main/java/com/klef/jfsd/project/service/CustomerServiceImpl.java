package com.klef.jfsd.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.repository.AdminRepository;
import com.klef.jfsd.project.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	

	@Override
	public String addcustomer(Customer c) {
		customerRepository.save(c);
	     return "Registration Successful";
	}



	@Override
	public Customer checkcustomerlogin(String email, String password) {
		
		return customerRepository.checkcustomerlogin(email, password);
	}

}
