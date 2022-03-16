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

import com.entity.GardenDecor;

import com.repository.GardenDecorRepository;
import com.serviceimpl.GardenDecorServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GardendecorServiceTest {

	@InjectMocks 
	private GardenDecorServiceImpl gardendecorservice;
	
	@Mock
	private GardenDecorRepository decorrepo;
	
	@Test
	public void addDecor()
	{
		GardenDecor decor = new GardenDecor();
		decor.setDecorId(1);
		when(gardendecorservice.addDecor(decor)).thenReturn(decor);
		assertEquals(decor, gardendecorservice.addDecor(decor));
	}
	
	@Test
	public void getGardenDecor()
	{
		GardenDecor d= new GardenDecor();
		d.setDecorId(1);
		d.setDecorName("Fountains");
		d.setDecorQuantity(2.0);
		d.setDecorPrice(20.0);
		
		List<GardenDecor> decorlist = new ArrayList<>();
		decorlist.add(d);
		
		Mockito.when(decorrepo.findAll()).thenReturn(decorlist);
		assertThat(gardendecorservice.getAllDecor()).isEqualTo(decorlist);
		
	}
	
	@Test
	
	void testGetDecorById() throws Throwable {
		
		GardenDecor d= new GardenDecor();
		d.setDecorId(1);
		d.setDecorName("Fountains");
		d.setDecorQuantity(2.0);
		d.setDecorPrice(20.0);
		 
		Optional<GardenDecor> c2=Optional.of(d);
		
		Mockito.when(decorrepo.findById(1)).thenReturn(c2);
		
		assertThat(gardendecorservice.getDecorById(1)).isEqualTo(d);
	}
	
	@Test
	void testUpdatePlant() throws Throwable {
		GardenDecor d= new GardenDecor();
		d.setDecorId(1);
		d.setDecorName("Fountains");
		d.setDecorQuantity(2.0);
		d.setDecorPrice(20.0);
		 
		Optional<GardenDecor> c2=Optional.of(d);
		
		Mockito.when(decorrepo.findById(1)).thenReturn(c2);
		
		Mockito.when(decorrepo.save(d)).thenReturn(d);
		d.setDecorName("Pot Stand");
		d.setDecorQuantity(2.0);
		d.setDecorPrice(20.0);
		
		assertThat(gardendecorservice.updateGardenDecor(d)).isEqualTo(d);
	}
	
	
}
