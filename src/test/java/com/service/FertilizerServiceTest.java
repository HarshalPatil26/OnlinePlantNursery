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

import com.entity.Fertilizer;

import com.repository.FertilizerRepository;
import com.serviceimpl.FertilizerServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FertilizerServiceTest {

	@InjectMocks
	private FertilizerServiceImpl fertilizerservice;
	
	@Mock
	private FertilizerRepository fertirepo;
	
	
	@Test
	public void addFertilizer()
	{
		Fertilizer ferti = new Fertilizer();
		ferti.setFertilizerId(1);
		when(fertilizerservice.addFertilizer(ferti)).thenReturn(ferti);
		assertEquals(ferti, fertilizerservice.addFertilizer(ferti));
	}
	
	@Test
	public void getFertilizer()
	{
	    Fertilizer f =new Fertilizer();
	    f.setFertilizerId(1);
	    f.setFertilizerName("Sodium");
	    f.setFertilizerPrice(200.0);
	    f.setFertilizerQuantity(3.0);
	    f.setFertilizerDescription("Nitrate");
		
		List<Fertilizer> fertilizerlist = new ArrayList<>();
		fertilizerlist.add(f);
		
		Mockito.when(fertirepo.findAll()).thenReturn(fertilizerlist);
		assertThat(fertilizerservice.getAllFertilizer()).isEqualTo(fertilizerlist);
		
	}
	
	@Test
	
	void testGetPlantById() throws Throwable {
		
		Fertilizer f =new Fertilizer();
	    f.setFertilizerId(1);
	    f.setFertilizerName("Sodium");
	    f.setFertilizerPrice(200.0);
	    f.setFertilizerQuantity(3.0);
	    f.setFertilizerDescription("Nitrate");
		 
		Optional<Fertilizer> c2=Optional.of(f);
		
		Mockito.when(fertirepo.findById(1)).thenReturn(c2);
		
		assertThat(fertilizerservice.getFertilizerById(1)).isEqualTo(f);
	}
	
	@Test
	void testUpdatePlant() throws Throwable {
		Fertilizer f =new Fertilizer();
	    f.setFertilizerId(1);
	    f.setFertilizerName("Sodium");
	    f.setFertilizerPrice(200.0);
	    f.setFertilizerQuantity(3.0);
	    f.setFertilizerDescription("Nitrate");
		 
		Optional<Fertilizer> c2=Optional.of(f);
		
		Mockito.when(fertirepo.findById(1)).thenReturn(c2);
		
		Mockito.when(fertirepo.save(f)).thenReturn(f);
		f.setFertilizerName("Urea");
	    f.setFertilizerPrice(200.0);
	    f.setFertilizerQuantity(3.0);
	    f.setFertilizerDescription("Nitrate");
		
		assertThat(fertilizerservice.updateFertiizer(f)).isEqualTo(f);
	}
	
	
}
