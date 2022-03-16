package com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.entity.Plant;
import com.repository.PlantRepository;
import com.service.PlantService;
import com.serviceimpl.PlantServiceImpl;

@RestController
@RequestMapping("/api/plant")
public class PlantController {

	private PlantService plantservice;

	public PlantController(PlantService plantservice) {
		super();
		this.plantservice = plantservice;
	}
	
	//addd plant
	@PostMapping("/addplant")
	public ResponseEntity<Plant> savePlant(@RequestBody Plant plant)
	{
		return new ResponseEntity<Plant>(plantservice.savePlant(plant), HttpStatus.CREATED);
	}
	
	//get all plants
	@GetMapping("/getplant")
	public List<Plant> getAllPlant()
	{
		return plantservice.getAllPlants();
		
	}
	
	@GetMapping("/getplantby/{plantId}")
	public ResponseEntity<Plant> getPlantById(@PathVariable int plantId) throws Throwable
	{
		Plant p = plantservice.getPlantById(plantId);
		return new ResponseEntity<Plant>(p, HttpStatus.OK);
	}
	
	
	
	//get plant by name
	
	@GetMapping("/getplant/{plantName}")
	public ResponseEntity<Plant> getPlantByName(@PathVariable String plantName)
   {
	Plant p = plantservice.getPlantByName(plantName);
	return new ResponseEntity<Plant>(p, HttpStatus.OK);
	}
	
	//get plant by type
	
	@GetMapping("/getPlant/{plantType}")
	public ResponseEntity<Plant> getPlantByType(@PathVariable String plantType)
	{
		Plant p =  plantservice.getPlantByType(plantType);
		return new ResponseEntity<Plant>(p, HttpStatus.OK);
	}
	
	@PutMapping(path="/updateplant")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant e) throws Throwable
     {
	 Plant e1 = plantservice.updatePlant(e) ;
	 ResponseEntity re = new ResponseEntity<Plant>(e1,HttpStatus.OK);
	 return re; 
	}
	
	@DeleteMapping(path="/deletePlantById/{plantId}")
	public ResponseEntity<String> deletePlantById(@PathVariable int plantId)
	{
		plantservice.deletePlantById(plantId);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}

}