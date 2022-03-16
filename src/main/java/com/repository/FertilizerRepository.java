package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Fertilizer;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Integer> {

	

	Fertilizer findByFertilizerName(String fertilizerName);

}
