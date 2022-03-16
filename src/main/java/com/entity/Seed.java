package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Seed {

	@Id
	private int seedId;
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String seedName;
	public double seedQuantity;
	private String seedDescription;
	public double seedPrice;
	
	public Seed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seed(int seedId, String seedName, double seedQuantity, String seedDescription,double seedPrice) {
		super();
		this.seedId = seedId;
		this.seedName = seedName;
		this.seedQuantity = seedQuantity;
		this.seedDescription = seedDescription;
		this.seedPrice=seedPrice;
	}
	
	

	public double getSeedPrice() {
		return seedPrice;
	}

	public void setSeedPrice(double seedPrice) {
		this.seedPrice = seedPrice;
	}

	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

	public String getSeedName() {
		return seedName;
	}

	public void setSeedName(String seedName) {
		this.seedName = seedName;
	}

	public double getSeedQuantity() {
		return seedQuantity;
	}

	public void setSeedQuantity(double seedQuantity) {
		this.seedQuantity = seedQuantity;
	}

	public String getSeedDescription() {
		return seedDescription;
	}

	public void setSeedDescription(String seedDescription) {
		this.seedDescription = seedDescription;
	}

	@Override
	public String toString() {
		return "Seed [seedId=" + seedId + ", seedName=" + seedName + ", seedQuantity=" + seedQuantity
				+ ", seedDescription=" + seedDescription + ", seedPrice=" + seedPrice + "]";
	}


	
	
	
	
}
