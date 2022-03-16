package com.service;

import com.entity.CustomerReg;

public interface CustomerRegService {

	CustomerReg addCustomer(CustomerReg customer);

	

	CustomerReg getCustomerByPhone(String customerPhone) throws Throwable;



	CustomerReg getCustomerById(int customerId) throws Throwable;



	CustomerReg updateCustomer(CustomerReg c) throws Throwable;

}
