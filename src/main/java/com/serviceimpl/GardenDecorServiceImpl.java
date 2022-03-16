package com.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.advice.ResourceNotFoundException;
import com.entity.GardenDecor;
import com.entity.Plant;
import com.entity.Planter;
import com.repository.GardenDecorRepository;
import com.service.GardenDecorService;

@Service
public class GardenDecorServiceImpl implements GardenDecorService{

	private GardenDecorRepository gardendecorrepo;
	
	public GardenDecorServiceImpl(GardenDecorRepository gardendecorrepo) {
		super();
		this.gardendecorrepo = gardendecorrepo;
	}

	@Override
	public GardenDecor addDecor(GardenDecor decor) {
		
		return gardendecorrepo.save(decor);
	}

	@Override
	public List<GardenDecor> getAllDecor() {
		
		return gardendecorrepo.findAll();
	}

	@Override
	public GardenDecor getDecorById(int decorId) throws Throwable
	{
		Supplier s1   = ()->new ResourceNotFoundException("Coder Does not Exist in the database");
		GardenDecor c = gardendecorrepo.findById(decorId).orElseThrow(s1);
		return c;
	}
	
	
	@Override
	public GardenDecor updateGardenDecor(GardenDecor e) throws Throwable {
		
		int id =e.getDecorId();
		Supplier s1=()-> new ResourceNotFoundException("Garden-Decor Not Found");
		GardenDecor c1 =gardendecorrepo.findById(id).orElseThrow(s1);
		
		c1.setDecorName(e.getDecorName());
		c1.setDecorPrice(e.getDecorPrice());
		c1.setDecorQuantity(e.getDecorQuantity());
		
		gardendecorrepo.save(c1);
		return c1;
		
	}
	
	@Override
	public String deleteDecorById(int decorId)
	{
		gardendecorrepo.deleteById(decorId);
		return "Deleted";
	}
	

	
}
