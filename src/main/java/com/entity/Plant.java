package com.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Plant {
    
	@Id
	
	private int plantId;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String plantName;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String plantType;
	public double plantPrice;
	private String plantDescription;
	public double plantQuantity;
	
	
	
	/*
	 * @JsonBackReference
	 * 
	 * @OneToOne(targetEntity = CartP.class, cascade = CascadeType.ALL) private
	 * CartP cartp;
	 */
	
	public Plant() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	


	public Plant(int plantId, String plantName, String plantType, double plantPrice, String plantDescription,
			double plantQuantity) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantType = plantType;
		this.plantPrice = plantPrice;
		this.plantDescription = plantDescription;
		this.plantQuantity = plantQuantity;
	}







	/*
	 * public CartP getCartp() { return cartp; }
	 * 
	 * 
	 * public void setCartp(CartP cartp) { this.cartp = cartp; }
	 */


	public int getPlantId() {
		return plantId;
	}


	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}


	public String getPlantName() {
		return plantName;
	}


	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}


	public String getPlantType() {
		return plantType;
	}


	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}


	public double getPlantPrice() {
		return plantPrice;
	}


	public void setPlantPrice(double plantPrice) {
		this.plantPrice = plantPrice;
	}


	public String getPlantDescription() {
		return plantDescription;
	}


	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	
	

	


	public double getPlantQuantity() {
		return plantQuantity;
	}







	public void setPlantQuantity(double plantQuantity) {
		this.plantQuantity = plantQuantity;
	}







	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantName=" + plantName + ", plantType=" + plantType + ", plantPrice="
				+ plantPrice + ", plantDescription=" + plantDescription + ", plantQuantity=" + plantQuantity + "]";
	}









	

	
	
	
}
