package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Planter {

	@Id
	private int planterid;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String planterName;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String planterColor;
	public double planterPrice;
	public double planterQuantity;
	
	
	public Planter() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Planter(int planterid, String planterName, String planterColor, double planterPrice,
			double planterQuantity) {
		super();
		this.planterid = planterid;
		this.planterName = planterName;
		this.planterColor = planterColor;
		this.planterPrice = planterPrice;
		this.planterQuantity = planterQuantity;
	}




	public String getPlanterColor() {
		return planterColor;
	}
	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}
	
	public double getPlanterPrice() {
		return planterPrice;
	}
	public void setPlanterPrice(double planterPrice) {
		this.planterPrice = planterPrice;
	}




	

	public int getPlanterid() {
		return planterid;
	}


	public void setPlanterid(int planterid) {
		this.planterid = planterid;
	}


	public String getPlanterName() {
		return planterName;
	}


	public void setPlanterName(String planterName) {
		this.planterName = planterName;
	}





	public double getPlanterQuantity() {
		return planterQuantity;
	}




	public void setPlanterQuantity(double planterQuantity) {
		this.planterQuantity = planterQuantity;
	}




	@Override
	public String toString() {
		return "Planter [planterid=" + planterid + ", planterName=" + planterName + ", planterColor=" + planterColor
				+ ", planterPrice=" + planterPrice + ", planterQuantity=" + planterQuantity + "]";
	}







	
	
	
}
