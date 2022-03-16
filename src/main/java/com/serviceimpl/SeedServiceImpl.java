package com.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.advice.ResourceNotFoundException;
import com.entity.Plant;
import com.entity.Seed;
import com.repository.SeedRepository;
import com.service.SeedService;

@Service
public class SeedServiceImpl implements SeedService {

	private SeedRepository seedrepository;
	
	
	public SeedServiceImpl(SeedRepository seedrepository) {
		super();
		this.seedrepository = seedrepository;
	}
	
	

	@Override
	public Seed addSeed(Seed seed) {
		
		return seedrepository.save(seed);
	}

	@Override
	public List<Seed> getAllSeed() {
		
		return seedrepository.findAll();
	}
	
	
	@Override
	public Seed getSeedById(int seedId) throws Throwable
	{
		Supplier s1   = ()->new ResourceNotFoundException("Coder Does not Exist in the database");
		Seed c = seedrepository.findById(seedId).orElseThrow(s1);
		return c;
	}
	

	@Override
	public Seed getSeedByName(String seedName) {
		return seedrepository.findBySeedName(seedName);
		
	}
	
	@Override
	public Seed updateSeed(Seed c) throws Throwable
	{
		int id =c.getSeedId();
		Supplier s1=()-> new ResourceNotFoundException("Seed Not Found");
		Seed c1 =seedrepository.findById(id).orElseThrow(s1);
		c1.setSeedName(c.getSeedName());
		c1.setSeedQuantity(c.getSeedQuantity());
		c1.setSeedDescription(c.getSeedDescription());
		c1.setSeedPrice(c.getSeedPrice());
		c1.setSeedQuantity(c.getSeedQuantity());
		
		seedrepository.save(c1);
		return c1;
	}
	
	@Override
	public String deleteSeedById(int seedId)
	{
       seedrepository.deleteById(seedId);
		return "Deleted";
	}


}
