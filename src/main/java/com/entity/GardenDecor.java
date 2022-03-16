package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class GardenDecor {

	@Id
	private int decorId;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String decorName;
	public double decorPrice;
	public double decorQuantity;
	
	public GardenDecor() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	public GardenDecor(int decorId, String decorName, double decorPrice, double decorQuantity) {
		super();
		this.decorId = decorId;
		this.decorName = decorName;
		this.decorPrice = decorPrice;
		this.decorQuantity = decorQuantity;
	}





	public double getDecorPrice() {
		return decorPrice;
	}

	public void setDecorPrice(double decorPrice) {
		this.decorPrice = decorPrice;
	}

	public int getDecorId() {
		return decorId;
	}

	public void setDecorId(int decorId) {
		this.decorId = decorId;
	}

	public String getDecorName() {
		return decorName;
	}

	public void setDecorName(String decorName) {
		this.decorName = decorName;
	}

	
	
	
	public double getDecorQuantity() {
		return decorQuantity;
	}





	public void setDecorQuantity(double decorQuantity) {
		this.decorQuantity = decorQuantity;
	}





	@Override
	public String toString() {
		return "GardenDecor [decorId=" + decorId + ", decorName=" + decorName + ", decorPrice=" + decorPrice
				+ ", decorQuantity=" + decorQuantity + "]";
	}








	
	
	
	
}
