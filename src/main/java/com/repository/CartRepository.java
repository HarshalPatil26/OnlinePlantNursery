package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.CartP;
import com.entity.CustomerReg;

public interface CartRepository extends JpaRepository<CartP, Integer>{

	

}
