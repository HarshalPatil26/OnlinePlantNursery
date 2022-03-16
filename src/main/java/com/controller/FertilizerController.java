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

import com.entity.Fertilizer;
import com.entity.Plant;
import com.service.FertilizerService;

@RestController
@RequestMapping("/api/fertilizer")
public class FertilizerController {

	private FertilizerService fertilizerservice;

	public FertilizerController(FertilizerService fertilizerservice) {
		super();
		this.fertilizerservice = fertilizerservice;
	}
	
	
	@PostMapping("/addfertilizer")
	public ResponseEntity<Fertilizer> addFertilizer(@RequestBody Fertilizer  fertilizer)
	{
		return new ResponseEntity<Fertilizer>(fertilizerservice.addFertilizer(fertilizer), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getfertilizer")
	public List<Fertilizer> getAllFertilizer()
	{
		return fertilizerservice.getAllFertilizer();
	}
	
	@GetMapping("/getfertilizerby/{fertilizerId}")
	public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable int fertilizerId) throws Throwable
	{
		Fertilizer p = fertilizerservice.getFertilizerById(fertilizerId);
		return new ResponseEntity<Fertilizer>(p, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getfertilizer/{fertilizerName}")
	public ResponseEntity<Fertilizer> getFertilizerByName(@PathVariable String fertilizerName)
	{
		
		return new ResponseEntity<Fertilizer>(fertilizerservice.getFertilizerByName(fertilizerName), HttpStatus.OK);
	}
	
	@PutMapping(path="/updatefertilizer")
	public ResponseEntity<Fertilizer> updateFertilizer(@RequestBody Fertilizer e) throws Throwable
     {
	 Fertilizer e1 = fertilizerservice.updateFertiizer(e) ;
	 ResponseEntity re = new ResponseEntity<Fertilizer>(e1,HttpStatus.OK);
	 return re; 
	}

	@DeleteMapping(path="/deletefertilizerById/{eid}")
	public ResponseEntity<String> deleteFertilizerById(@PathVariable int eid)
	{
		fertilizerservice.deleteFertilizerById(eid);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
}
