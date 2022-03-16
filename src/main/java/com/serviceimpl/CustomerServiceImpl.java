package com.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.advice.ResourceNotFoundException;
import com.entity.CustomerReg;
import com.entity.Plant;
import com.repository.CustomerRegRepo;
import com.service.CustomerRegService;

@Service
public class CustomerServiceImpl implements CustomerRegService {

	private CustomerRegRepo customerrepo;

	public CustomerServiceImpl(CustomerRegRepo customerrepo) {
		super();
		this.customerrepo = customerrepo;
	}
	
	
	@Override
	public CustomerReg addCustomer(CustomerReg customer)
	{
		
		
		return customerrepo.save(customer);
	}
	
	@Override
	public CustomerReg getCustomerByPhone(String customerPhone) throws Throwable
	{
		
		CustomerReg customer =customerrepo.findByCustomerPhone(customerPhone);
		
		return customer;
	}
	
	@Override
	public CustomerReg getCustomerById(int customerId) throws Throwable
	{
		Supplier s1   = ()->new ResourceNotFoundException("Coder Does not Exist in the database");
		CustomerReg c = customerrepo.findById(customerId).orElseThrow(s1);
		return c;
	}
	
	@Override
	public CustomerReg updateCustomer(CustomerReg c) throws Throwable
	{
		int id =c.getCustomerId();
		Supplier s1=()-> new ResourceNotFoundException("Plant Not Found");
		CustomerReg c1 =customerrepo.findById(id).orElseThrow(s1);
		c1.setCustomerName(c.getCustomerName());
		c1.setCustomerEmail(c.getCustomerEmail());
		c1.setCustomerPhone(c.getCustomerPhone());
		c1.setPassword(c.getPassword());
		customerrepo.save(c1);
		return c1;
	}

	
}
