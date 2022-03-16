package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.entity.Plant;
import com.repository.PlantRepository;
import com.serviceimpl.PlantServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlantServiceTest {

	@InjectMocks
	private PlantServiceImpl plantservice;
	
	@Mock
	private PlantRepository plantrepo;
	
	@Test
	public void savePlant()
	{
		Plant plant = new Plant();
		plant.setPlantId(2);
		when(plantservice.savePlant(plant)).thenReturn(plant);
		assertEquals(plant, plantservice.savePlant(plant));
	}
	
	@Test
	public void getPlant()
	{
		Plant p= new Plant();
		p.setPlantId(1);
		p.setPlantName("Apple");
		p.setPlantType("Shrub");
		p.setPlantDescription("Tall");
		p.setPlantPrice(20.0);
		p.setPlantQuantity(3.0);
		
		List<Plant> plantlist = new ArrayList<>();
		plantlist.add(p);
		
		Mockito.when(plantrepo.findAll()).thenReturn(plantlist);
		assertThat(plantservice.getAllPlants()).isEqualTo(plantlist);
		
	}
	
	@Test
	
	void testGetPlantById() throws Throwable {
		Plant p= new Plant();
		p.setPlantId(1);
		p.setPlantName("Apple");
		p.setPlantType("Shrub");
		p.setPlantDescription("Tall");
		p.setPlantPrice(20.0);
		p.setPlantQuantity(3.0);
		 
		 
		Optional<Plant> c2=Optional.of(p);
		
		Mockito.when(plantrepo.findById(1)).thenReturn(c2);
		
		assertThat(plantservice.getPlantById(1)).isEqualTo(p);
	}
	
	@Test
	void testUpdatePlant() throws Throwable {
		Plant p= new Plant();
		p.setPlantId(1);
		p.setPlantName("Apple");
		p.setPlantType("Shrub");
		p.setPlantDescription("Tall");
		p.setPlantPrice(20.0);
		p.setPlantQuantity(3.0);
		 
		 
		Optional<Plant> c2=Optional.of(p);
		
		Mockito.when(plantrepo.findById(1)).thenReturn(c2);
		
		Mockito.when(plantrepo.save(p)).thenReturn(p);
		p.setPlantName("Lemon");
		p.setPlantType("Shrub");
		p.setPlantDescription("Small");
		p.setPlantPrice(20.0);
		p.setPlantQuantity(3.0);
		
		assertThat(plantservice.updatePlant(p)).isEqualTo(p);
	}
	
}
