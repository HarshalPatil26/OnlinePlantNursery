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


import com.entity.Seed;
import com.repository.SeedRepository;
import com.serviceimpl.SeedServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SeedServiceTest {

	@InjectMocks
	private SeedServiceImpl seedservice;
	
	@Mock
	private SeedRepository seedrepo;
	
	@Test
	public void addSeed()
	{
		Seed seed = new Seed();
		seed.setSeedId(1);
		seed.setSeedName("Mango");
		seed.setSeedDescription("good");
		seed.setSeedPrice(10.0);
		when(seedservice.addSeed(seed)).thenReturn(seed);
		assertEquals(seed, seedservice.addSeed(seed));
	}
	
	@Test
	public void getSeed()
	{
		Seed s= new Seed();
		s.setSeedId(1);
		s.setSeedName("Apple seed");
		s.setSeedDescription("Fruit");
		s.setSeedPrice(20.0);
		s.setSeedQuantity(2.0);
		
		List<Seed> seedlist = new ArrayList<>();
		seedlist.add(s);
		
		Mockito.when(seedrepo.findAll()).thenReturn(seedlist);
		assertThat(seedservice.getAllSeed()).isEqualTo(seedlist);
		
	}
	
	@Test
	
	void testGetSeedById() throws Throwable {
		Seed s= new Seed();
		s.setSeedId(1);
		s.setSeedName("Apple seed");
		s.setSeedDescription("Fruit");
		s.setSeedPrice(20.0);
		s.setSeedQuantity(2.0);
		 
		 
		Optional<Seed> c2=Optional.of(s);
		
		Mockito.when(seedrepo.findById(1)).thenReturn(c2);
		
		assertThat(seedservice.getSeedById(1)).isEqualTo(s);
	}
	
	@Test
	void testUpdateSeed() throws Throwable {
	
		Seed s= new Seed();
		s.setSeedId(1);
		s.setSeedName("Apple seed");
		s.setSeedDescription("Fruit");
		s.setSeedPrice(20.0);
		s.setSeedQuantity(2.0);
		 
		 
		Optional<Seed> c2=Optional.of(s);
		 
		
		Mockito.when(seedrepo.findById(1)).thenReturn(c2);
		
		Mockito.when(seedrepo.save(s)).thenReturn(s);
		
		s.setSeedName("Mango seed");
		s.setSeedDescription("Fruit");
		s.setSeedPrice(20.0);
		s.setSeedQuantity(2.0);
		 
		
		assertThat(seedservice.updateSeed(s)).isEqualTo(s);
	}
	
	
}
