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
import com.entity.Planter;
import com.service.PlanterService;

@RestController
@RequestMapping("/api/planter")
public class PlanterController {

	private PlanterService planterservice;

	public PlanterController(PlanterService planterservice) {
		super();
		this.planterservice = planterservice;
	}
	
	@PostMapping("/addplanter")
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter)
	{
		return new ResponseEntity<Planter>(planterservice.addPlanter(planter), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getPlanter")
	public List<Planter> getAllPlanter()
	{
		return planterservice.getAllPlanter();
	}
	
	@GetMapping("/getplanterby/{planterId}")
	public ResponseEntity<Planter> getPlantById(@PathVariable int planterId) throws Throwable
	{
		Planter p = planterservice.getPlanterById(planterId);
		return new ResponseEntity<Planter>(p, HttpStatus.OK);
	}
	
	
	@PutMapping(path="/updateplanter")
	public ResponseEntity<Planter> updatePlanter(@RequestBody Planter e) throws Throwable
     {
	 Planter e1 = planterservice.updatePlanter(e) ;
	 ResponseEntity re = new ResponseEntity<Planter>(e1,HttpStatus.OK);
	 return re; 
	}
	
	@DeleteMapping(path="/deletePlanterById/{eid}")
	public ResponseEntity<String> deletePlanterById(@PathVariable int eid)
	{
	planterservice.deletePlanterById(eid);
	ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
	return re;
	}
	}
	

	
