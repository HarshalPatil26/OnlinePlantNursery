package com.service;

import java.util.List;

import com.entity.Fertilizer;

public interface FertilizerService {

	String deleteFertilizerById(int cid);

	Fertilizer updateFertiizer(Fertilizer c) throws Throwable;

	Fertilizer getFertilizerByName(String fertilizerName);

	List<Fertilizer> getAllFertilizer();

	Fertilizer addFertilizer(Fertilizer fertilizer);

	Fertilizer getFertilizerById(int fertilizerId) throws Throwable;

}
