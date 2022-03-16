package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Plant;


@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

	Plant findByplantName(String plantName);
	
	Plant findByplantType(String plantType);

}
