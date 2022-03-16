package com.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.advice.ResourceNotFoundException;

import com.entity.Plant;
import com.repository.PlantRepository;
import com.service.PlantService;



@Service
public class PlantServiceImpl implements PlantService {

	private PlantRepository plantrepository;
	@Autowired
	public PlantServiceImpl(PlantRepository plantrepository) {
		super();
		this.plantrepository = plantrepository;
	}



	@Override
	public Plant savePlant(Plant plant) {
		
		return plantrepository.save(plant);
	}



	@Override
	public List<Plant> getAllPlants() {
		
		return plantrepository.findAll();
	}

	@Override
	public Plant getPlantById(int plantId) throws Throwable
	{
		Supplier s1   = ()->new ResourceNotFoundException("Coder Does not Exist in the database");
		Plant c = plantrepository.findById(plantId).orElseThrow(s1);
		return c;
	}


	@Override
	public Plant getPlantByName(String plantName) {
		
		Plant plant =plantrepository.findByplantName(plantName);
		
		return plant;
	}



	@Override
	public Plant getPlantByType(String plantType) {
		
		Plant plant = plantrepository.findByplantType(plantType);
		return plant;
	}

	@Override
	public Plant updatePlant(Plant c) throws Throwable
	{
		int id =c.getPlantId();
		Supplier s1=()-> new ResourceNotFoundException("Plant Not Found");
		Plant c1 =plantrepository.findById(id).orElseThrow(s1);
		c1.setPlantName(c.getPlantName());
		c1.setPlantType(c.getPlantType());
		c1.setPlantPrice(c.getPlantPrice());
		c1.setPlantDescription(c.getPlantDescription());
		c1.setPlantQuantity(c.getPlantQuantity());
		plantrepository.save(c1);
		return c1;
	}

	@Override
	public String deletePlantById(int cid)
	{
		plantrepository.deleteById(cid);
		return "Deleted";
	}

}
