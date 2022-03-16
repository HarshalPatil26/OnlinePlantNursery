package com.service;

import java.util.List;

import com.entity.Plant;

public interface PlantService {

	Plant  savePlant(Plant plant);
	
	List<Plant> getAllPlants();
	
	Plant getPlantByName(String plantName);
	
	Plant getPlantByType(String plantType);
	
   Plant updatePlant(Plant e) throws Throwable;

	String deletePlantById(int cid);

	Plant getPlantById(int plantId) throws Throwable;
}
