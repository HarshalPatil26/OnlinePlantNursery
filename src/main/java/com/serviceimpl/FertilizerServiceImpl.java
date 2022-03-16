package com.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.advice.ResourceNotFoundException;
import com.entity.Fertilizer;
import com.entity.Plant;
import com.repository.FertilizerRepository;
import com.service.FertilizerService;

@Service
public class FertilizerServiceImpl implements FertilizerService {

	private FertilizerRepository fertilizerrepository;

	public FertilizerServiceImpl(FertilizerRepository fertilizerrepository) {
		super();
		this.fertilizerrepository = fertilizerrepository;
	}
	
	@Override
	public Fertilizer addFertilizer(Fertilizer fertilizer) {
		
		return fertilizerrepository.save(fertilizer);
	}

	@Override
	public List<Fertilizer> getAllFertilizer() {
		
		return fertilizerrepository.findAll();
	}

	@Override
	public Fertilizer getFertilizerById(int fertilizerId) throws Throwable
	{
		Supplier s1   = ()->new ResourceNotFoundException("Coder Does not Exist in the database");
		Fertilizer c = fertilizerrepository.findById(fertilizerId).orElseThrow(s1);
		return c;
	}
	
	
	@Override
	public Fertilizer getFertilizerByName(String fertilizerName) {
		return fertilizerrepository.findByFertilizerName(fertilizerName);
		
	}
	
	@Override
	public Fertilizer updateFertiizer(Fertilizer c) throws Throwable
	{
		int id =c.getFertilizerId();
		Supplier s1=()-> new ResourceNotFoundException("Fertilizer Not Found");
		Fertilizer c1 =fertilizerrepository.findById(id).orElseThrow(s1);
		c1.setFertilizerName(c.getFertilizerName());
		c1.setFertilizerPrice(c.getFertilizerPrice());
		c1.setFertilizerDescription(c.getFertilizerDescription());
		c1.setFertilizerQuantity(c.getFertilizerQuantity());
		
		fertilizerrepository.save(c1);
		return c1;
	}
	
	@Override
	public String deleteFertilizerById(int cid)
	{
       fertilizerrepository.deleteById(cid);
		return "Deleted";
	}
	
}
