package com.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CustomerReg;
import com.entity.Plant;
import com.service.CustomerRegService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRegController {

	private CustomerRegService customerreg;

	public CustomerRegController(CustomerRegService customerreg) {
		super();
		this.customerreg = customerreg;
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<CustomerReg> addCustomer(@Valid @RequestBody CustomerReg customer)
	{
		return new ResponseEntity<CustomerReg>(customerreg.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/getcustomerby/{customerId}")
	public ResponseEntity<CustomerReg> getCustomerById(@PathVariable int customerId) throws Throwable
	{
		CustomerReg p = customerreg.getCustomerById(customerId);
		return new ResponseEntity<CustomerReg>(p, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getcustomer/{customerPhone}")
	public ResponseEntity<CustomerReg> getCustomerByPhone(@PathVariable String customerPhone) throws Throwable
   {
	CustomerReg cus = customerreg.getCustomerByPhone(customerPhone);
	return new ResponseEntity<CustomerReg>(cus, HttpStatus.OK);
   }
	
	@PutMapping(path="/updatecustomer")
	public ResponseEntity<CustomerReg> updateCustomer(@RequestBody CustomerReg e) throws Throwable
     {
	 CustomerReg e1 = customerreg.updateCustomer(e) ;
	 ResponseEntity re = new ResponseEntity<CustomerReg>(e1,HttpStatus.OK);
	 return re; 
	}
	
	
}

	

