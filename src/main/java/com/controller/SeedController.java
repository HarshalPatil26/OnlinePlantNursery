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
import com.entity.Seed;
import com.service.SeedService;
import com.serviceimpl.SeedServiceImpl;

@RestController
@RequestMapping("/api/seed")
public class SeedController {

	private SeedService seedservice;

	public SeedController(SeedService seedservice) {
		super();
		this.seedservice = seedservice;
	}
	
	
	@PostMapping("/addseed")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed  seed)
	{
		return new ResponseEntity<Seed>(seedservice.addSeed(seed), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getseed")
	public List<Seed> getAllSeed()
	{
		return seedservice.getAllSeed();
	}
	
	
	@GetMapping("/getseedby/{seedId}")
	public ResponseEntity<Seed> getSeedById(@PathVariable int seedId) throws Throwable
	{
		Seed s = seedservice.getSeedById(seedId);
		return new ResponseEntity<Seed>(s, HttpStatus.OK);
	}
	
	
	@GetMapping("/getSeed/{seedName}")
	public ResponseEntity<Seed> getSeedByName(@PathVariable String seedName)
	{
		
		return new ResponseEntity<Seed>(seedservice.getSeedByName(seedName), HttpStatus.OK);
	}
	
	@PutMapping(path="/updateseed")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed e) throws Throwable
     {
	 Seed e1 = seedservice.updateSeed(e) ;
	 ResponseEntity re = new ResponseEntity<Seed>(e1,HttpStatus.OK);
	 return re; 
	}

	@DeleteMapping(path="/deleteSeedById/{seedId}")
	public ResponseEntity<String> deleteSeedById(@PathVariable int seedId)
	{
		seedservice.deleteSeedById(seedId);
		ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
}
