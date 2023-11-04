package com.klef.jfsd.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Admin;
import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.repository.AdminRepository;
import com.klef.jfsd.project.repository.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService
{

	@Autowired
	 private AdminRepository adminRepository;
	 
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public Admin checkadminlogin(String uname, String pwd) 
	{
		return adminRepository.checkadminlogin(uname, pwd);
	}


	public List<Customer> viewallcustomers() {
		return customerRepository.findAll();
	}


	@Override
	public String deletecus(int cid) {
		Optional<Customer> obj = customerRepository.findById(cid);
	      
	      String msg = null;
	      
	      if(obj.isPresent())
	      {
	        Customer cus = obj.get();
	        customerRepository.delete(cus);
	        msg = "Customer Deleted Successfully";
	      }
	      else
	      {
	        msg = "Customer Not Found";
	      }
	      
	      return msg;
	}

}
