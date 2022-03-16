package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CustomerReg;

public interface CustomerRegRepo extends JpaRepository<CustomerReg, Integer>{

	

	CustomerReg findByCustomerPhone(String customerPhone);

}
