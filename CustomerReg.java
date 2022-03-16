package com.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CustomerReg {

	@Id
	
	private int customerId;
	
	@NotEmpty(message="Name is required")
    @NotNull
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
     private String customerName;
	
	@NotEmpty(message="Email is required")
	@NotNull
	@Pattern(regexp = "^(.+)@(\\S+)$")
	private String customerEmail;
	
	@NotNull
	
	private String customerPhone;
	
	@NotEmpty(message="Password is required")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
	private String password;
	

	

	 
	
	
	
	public CustomerReg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerReg(int customerId, String customerName, String customerEmail, String customerPhone,
			String password,CartP cartp) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.password = password;
		
		
	}
	
	



	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerReg [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + ", password=" + password +
				"]";
	}

	



	
	
	
	
	
	
	
}
