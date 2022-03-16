package com.service;

import java.util.List;

import com.entity.GardenDecor;

public interface GardenDecorService {

	
	GardenDecor addDecor(GardenDecor decor);
	
	List<GardenDecor> getAllDecor();

	GardenDecor updateGardenDecor(GardenDecor e) throws Throwable;

	String deleteDecorById(int decorId);

	GardenDecor getDecorById(int decorId) throws Throwable;



	
	
}
