package com.service;

import java.util.List;

import com.entity.Plant;
import com.entity.Planter;

public interface PlanterService {

	Planter addPlanter(Planter planter);
	
	List<Planter> getAllPlanter();
	
	 

	Planter updatePlanter(Planter e) throws Throwable;

	String deletePlanterById(int planterId);

	Planter getPlanterById(int planterId) throws Throwable;


	
}
