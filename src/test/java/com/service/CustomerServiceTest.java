package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.entity.CustomerReg;
import com.entity.Plant;
import com.repository.CustomerRegRepo;
import com.serviceimpl.CustomerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerservice;
	
	@Mock
	private CustomerRegRepo customerrepo;
	
	@Test
	public void addCustomer()
	{
		CustomerReg customer = new CustomerReg();
		customer.setCustomerId(1);
		when(customerservice.addCustomer(customer)).thenReturn(customer);
		assertEquals(customer, customerservice.addCustomer(customer));
	}
	@Test
	
	void testGetPlantById() throws Throwable {
	CustomerReg c = new CustomerReg();
	
	c.setCustomerId(1);
	c.setCustomerName("uday12");
	c.setCustomerEmail("uday@gmail.com");
	c.setCustomerPhone("9898753673");
	c.setPassword("Uday@123");
		 
		 
		Optional<CustomerReg> c2=Optional.of(c);
		
		Mockito.when(customerrepo.findById(1)).thenReturn(c2);
		
		assertThat(customerservice.getCustomerById(1)).isEqualTo(c);
	}
	
	@Test
	void testUpdatePlant() throws Throwable {
	
		CustomerReg c = new CustomerReg();
		
		c.setCustomerId(1);
		c.setCustomerName("uday12");
		c.setCustomerEmail("uday@gmail.com");
		c.setCustomerPhone("9898753673");
		c.setPassword("Uday@123");
			 
			 
			Optional<CustomerReg> c2=Optional.of(c);
		Mockito.when(customerrepo.findById(1)).thenReturn(c2);
		
		Mockito.when(customerrepo.save(c)).thenReturn(c);
		c.setCustomerId(1);
		c.setCustomerName("uday123");
		c.setCustomerEmail("uday23@gmail.com");
		c.setCustomerPhone("9898753673");
		c.setPassword("Uday@123");
		
		assertThat(customerservice.updateCustomer(c)).isEqualTo(c);
	}
	

	
	
}
