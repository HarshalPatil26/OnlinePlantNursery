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

import com.entity.GardenDecor;
import com.entity.Plant;
import com.service.GardenDecorService;

@RestController
@RequestMapping("/api/gardendecor")
public class GardenDecorController {

	private GardenDecorService gardendecorservice;

	public GardenDecorController(GardenDecorService gardendecorservice) {
		super();
		this.gardendecorservice = gardendecorservice;
	}
	
	@PostMapping("/addDecor")
	public ResponseEntity<GardenDecor> addGardenDecor(@RequestBody GardenDecor decor)
	{
		return new ResponseEntity<GardenDecor>(gardendecorservice.addDecor(decor), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getDecor")
	public List<GardenDecor> getGardenDecor()
	{
		return gardendecorservice.getAllDecor();
		
	}
	
	@GetMapping("/getdecorby/{decorId}")
	public ResponseEntity<GardenDecor> getPlantById(@PathVariable int decorId) throws Throwable
	{
		GardenDecor p = gardendecorservice.getDecorById(decorId);
		return new ResponseEntity<GardenDecor>(p, HttpStatus.OK);
	}
	
	
	@PutMapping(path="/updateDecor")
	public ResponseEntity<GardenDecor> updateDecor(@RequestBody GardenDecor e) throws Throwable
     {
	 GardenDecor e1 = gardendecorservice.updateGardenDecor(e) ;
	 ResponseEntity re = new ResponseEntity<GardenDecor>(e1,HttpStatus.OK);
	 return re; 
	}
	
	@DeleteMapping(path="/deleteDecorById/{decorId}")
	public ResponseEntity<String> deletedecorById(@PathVariable int decorId) throws Throwable
	{
		gardendecorservice.deleteDecorById(decorId);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	

}
