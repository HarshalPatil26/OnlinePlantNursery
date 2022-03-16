package com.service;

import java.util.List;

import com.entity.Seed;

public interface SeedService {

	Seed addSeed(Seed seed);
	
	List<Seed> getAllSeed();
	
	Seed getSeedByName(String seedName);

	Seed updateSeed(Seed c) throws Throwable;

	String deleteSeedById(int seedId);

	Seed getSeedById(int seedId) throws Throwable;
	
	
	
}
