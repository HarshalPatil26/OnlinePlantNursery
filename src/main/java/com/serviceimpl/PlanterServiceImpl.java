package com.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.advice.ResourceNotFoundException;
import com.entity.GardenDecor;
import com.entity.Plant;
import com.entity.Planter;
import com.repository.PlanterRepository;
import com.service.PlanterService;

@Service
public class PlanterServiceImpl implements PlanterService {

	private PlanterRepository planterRepository;
	
	
	public PlanterServiceImpl(PlanterRepository planterRepository) {
		super();
		this.planterRepository = planterRepository;
	}




	@Override
	public Planter addPlanter(Planter planter) {
		
		return planterRepository.save(planter);
	}



	@Override
	public List<Planter> getAllPlanter() {
		
		return planterRepository.findAll();
	}


	
	@Override
	public Planter getPlanterById(int planterId) throws Throwable
	{
		Supplier s1   = ()->new ResourceNotFoundException("Coder Does not Exist in the database");
		Planter c = planterRepository.findById(planterId).orElseThrow(s1);
		return c;
	}


	@Override
	public Planter updatePlanter(Planter e) throws Throwable {
		
		int id =e.getPlanterid();
		Supplier s1=()-> new ResourceNotFoundException("Planter Not Found");
		Planter c1 =planterRepository.findById(id).orElseThrow(s1);
		
		c1.setPlanterName(e.getPlanterName());
		c1.setPlanterColor(e.getPlanterColor());
		c1.setPlanterPrice(e.getPlanterPrice());
		c1.setPlanterQuantity(e.getPlanterQuantity());
		
		planterRepository.save(c1);
		return c1;
		
	}
	
	@Override
	public String deletePlanterById(int planterId)
	{
		planterRepository.deleteById(planterId);
		return "Deleted";
	}
	

	
	

}
