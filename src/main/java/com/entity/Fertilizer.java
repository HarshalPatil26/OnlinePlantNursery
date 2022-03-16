package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Fertilizer {

	@Id
	private int fertilizerId;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String fertilizerName;
	public double fertilizerPrice;
	private String fertilizerDescription;
	public double fertilizerQuantity;
	
	public Fertilizer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Fertilizer(int fertilizerId, String fertilizerName, double fertilizerPrice, String fertilizerDescription,
			double fertilizerQuantity) {
		super();
		this.fertilizerId = fertilizerId;
		this.fertilizerName = fertilizerName;
		this.fertilizerPrice = fertilizerPrice;
		this.fertilizerDescription = fertilizerDescription;
		this.fertilizerQuantity = fertilizerQuantity;
	}



	public int getFertilizerId() {
		return fertilizerId;
	}

	public void setFertilizerId(int fertilizerId) {
		this.fertilizerId = fertilizerId;
	}

	public String getFertilizerName() {
		return fertilizerName;
	}

	public void setFertilizerName(String fertilizerName) {
		this.fertilizerName = fertilizerName;
	}

	public double getFertilizerPrice() {
		return fertilizerPrice;
	}

	public void setFertilizerPrice(double fertilizerPrice) {
		this.fertilizerPrice = fertilizerPrice;
	}

	public String getFertilizerDescription() {
		return fertilizerDescription;
	}

	public void setFertilizerDescription(String fertilizerDescription) {
		this.fertilizerDescription = fertilizerDescription;
	}

	
	
	
	public double getFertilizerQuantity() {
		return fertilizerQuantity;
	}



	public void setFertilizerQuantity(double fertilizerQuantity) {
		this.fertilizerQuantity = fertilizerQuantity;
	}



	@Override
	public String toString() {
		return "Fertilizer [fertilizerId=" + fertilizerId + ", fertilizerName=" + fertilizerName + ", fertilizerPrice="
				+ fertilizerPrice + ", fertilizerDescription=" + fertilizerDescription + ", fertilizerQuantity="
				+ fertilizerQuantity + "]";
	}



	
	
	
	
	
	
}
