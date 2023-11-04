package com.klef.jfsd.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Admin;
import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.repository.AdminRepository;

@Service
public interface AdminService
{
    public Admin checkadminlogin(String uname,String pwd);
    public List<Customer> viewallcustomers();
    public String deletecus(int cid);
}
