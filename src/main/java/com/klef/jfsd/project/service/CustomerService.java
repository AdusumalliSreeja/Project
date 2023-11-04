package com.klef.jfsd.project.service;

import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Customer;

@Service
public interface CustomerService
{
	
	public String addcustomer(Customer c);
	public Customer checkcustomerlogin(String email,String password);

}
