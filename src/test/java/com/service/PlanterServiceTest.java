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

import com.entity.Planter;

import com.repository.PlanterRepository;
import com.serviceimpl.PlanterServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanterServiceTest {

	@InjectMocks
	private PlanterServiceImpl planterservice;
	
	@Mock
	private PlanterRepository planterrepo;
	
	@Test
	public void addPlanter()
	{
		Planter planter = new Planter();
		planter.setPlanterid(2);
		when(planterservice.addPlanter(planter)).thenReturn(planter);
		assertEquals(planter, planterservice.addPlanter(planter));
		
	}
	
	@Test
	public void getPlanter()
	{
	    Planter p = new Planter();
	    p.setPlanterid(1);
	    p.setPlanterName("Plastic Pot");
	    p.setPlanterColor("red");
	    p.setPlanterPrice(200.0);
	    p.setPlanterQuantity(30.0);
		
		List<Planter> planterlist = new ArrayList<>();
		planterlist.add(p);
		
		Mockito.when(planterrepo.findAll()).thenReturn(planterlist);
		assertThat(planterservice.getAllPlanter()).isEqualTo(planterlist);
		
	}
	
	@Test
	
	void testGetPlanterById() throws Throwable {
		
		   Planter p = new Planter();
		    p.setPlanterid(1);
		    p.setPlanterName("Plastic Pot");
		    p.setPlanterColor("red");
		    p.setPlanterPrice(200.0);
		    p.setPlanterQuantity(30.0);
		 
		Optional<Planter> c2=Optional.of(p);
		
		Mockito.when(planterrepo.findById(1)).thenReturn(c2);
		
		assertThat(planterservice.getPlanterById(1)).isEqualTo(p);
	}
	
	@Test
	void testUpdateSeed() throws Throwable {
	
		   Planter p = new Planter();
		    p.setPlanterid(1);
		    p.setPlanterName("Plastic Pot");
		    p.setPlanterColor("red");
		    p.setPlanterPrice(200.0);
		    p.setPlanterQuantity(30.0);
		 
		Optional<Planter> c2=Optional.of(p);
		 
		
		Mockito.when(planterrepo.findById(1)).thenReturn(c2);
		
		Mockito.when(planterrepo.save(p)).thenReturn(p);
		p.setPlanterName("Ceramic Pot");
	    p.setPlanterColor("red");
	    p.setPlanterPrice(200.0);
	    p.setPlanterQuantity(30.0);

		
		assertThat(planterservice.updatePlanter(p)).isEqualTo(p);
	}
	
	
}
