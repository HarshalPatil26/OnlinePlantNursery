package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class CartP  {

	
	@Id
	private int cartId;
	
    

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="decorId")
	private GardenDecor gardendecor;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="planterId")
	private Planter planter;
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fertilizerId")
	private Fertilizer fertilizer;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="plantId")
	private Plant p;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seedId")
	private Seed s;
	

    
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private CustomerReg customerreg;

	
public CartP() {
	super();
	// TODO Auto-generated constructor stub
}


public CartP(int cartId, GardenDecor gardendecor, Planter planter, Fertilizer fertilizer, Plant p, Seed s,
		CustomerReg customerreg) {
	super();
	this.cartId = cartId;
	this.gardendecor = gardendecor;
	this.planter = planter;
	this.fertilizer = fertilizer;
	this.p = p;
	this.s = s;
	this.customerreg = customerreg;
}



@Override
public String toString() {
	return "CartP [cartId=" + cartId +  ", gardendecor=" + gardendecor + ", planter=" + planter
			+ ", fertilizer=" + fertilizer + ", p=" + p + ", s=" + s + ", customerreg=" + customerreg + "]";
}



public GardenDecor getGardendecor() {
	return gardendecor;
}





public void setGardendecor(GardenDecor gardendecor) {
	this.gardendecor = gardendecor;
}





public Planter getPlanter() {
	return planter;
}





public void setPlanter(Planter planter) {
	this.planter = planter;
}







public Fertilizer getFertilizer() {
	return fertilizer;
}

public void setFertilizer(Fertilizer fertilizer) {
	this.fertilizer = fertilizer;
}





public Seed getS() {
	return s;
}





public void setS(Seed s) {
	this.s = s;
}





public int getCartId() {
	return cartId;
}


public void setCartId(int cartId) {
	this.cartId = cartId;
}



public CustomerReg getCustomerreg() {
	return customerreg;
}




public Plant getP() {
	return p;
}


public void setP(Plant p) {
	this.p = p;
}


public void setCustomerreg(CustomerReg customerreg) {
	this.customerreg = customerreg;
}













 

public double total()
{
	return p.getPlantPrice()*p.getPlantQuantity()+s.getSeedPrice()*s.getSeedQuantity()+fertilizer.getFertilizerPrice()*fertilizer.getFertilizerQuantity()+planter.getPlanterPrice()*planter.getPlanterQuantity()+gardendecor.getDecorPrice()*gardendecor.getDecorQuantity();
}




	


	
	
	}
	 
	 

