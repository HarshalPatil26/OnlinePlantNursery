package com.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.advice.ResourceNotFoundException;
import com.entity.CartP;
import com.entity.CustomerReg;
import com.entity.Fertilizer;
import com.entity.GardenDecor;
import com.entity.Plant;
import com.entity.Planter;
import com.entity.Seed;
import com.repository.CartRepository;
import com.repository.CustomerRegRepo;
import com.repository.PlantRepository;
import com.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartrepo;

	private PlantRepository plantrepo;



	public CartServiceImpl(CartRepository cartrepo) {
		super();
		this.cartrepo = cartrepo;
	}

	@Override
	public CartP addProduct(CartP cartp) {
		return cartrepo.save(cartp);
	}

	@Override
	public String deleteProductById(int cid) {
		cartrepo.deleteById(cid);
		return "Deleted";
	}

	@Override
	public List<CartP> getCart() {
       List<CartP> list = cartrepo.findAll();
       list.forEach(c->System.out.println(c.getCartId()));
		return list;
	}

	@Override
	public CartP getCartById(int cartId) throws Throwable {
		Supplier s1 = () -> new ResourceNotFoundException("Cart Not Found");
		return cartrepo.findById(cartId).orElseThrow(s1);

	}

	@Override
	public String deleteCartById(int cartId) {
		cartrepo.deleteById(cartId);
		return "Deleted";
	}

	@Override
	public CartP updateCart(CartP c) throws Throwable {
		int id = c.getCartId();
		Supplier s1 = () -> new ResourceNotFoundException("Plant Not Found");
		CartP c1 = cartrepo.findById(id).orElseThrow(s1);
		c1.setP(c.getP());
		c1.setS(c.getS());
		c1.setPlanter(c.getPlanter());
		c1.setGardendecor(c.getGardendecor());
		c1.setFertilizer(c.getFertilizer());
		cartrepo.save(c1);
		return c1;
	}

	/*
	 * public double PrintBill() { return
	 * plant.plantPrice*plant.plantQuantity+seed.seedPrice*seed.seedQuantity+planter
	 * .planterPrice*planter.planterQuantity+fertilizer.fertilizerPrice+fertilizer.
	 * fertilizerQuantity+gardenDecor.decorPrice*gardenDecor.decorQuantity; }
	 * 
	 * double total=
	 * plant.getPlantPrice()*plant.getPlantQuantity()+seed.getSeedPrice()*seed.
	 * getSeedQuantity()+fertilizer.getFertilizerPrice()*fertilizer.
	 * getFertilizerQuantity()+planter.getPlanterPrice()*planter.getPlanterQuantity(
	 * )+gardenDecor.getDecorPrice()*gardenDecor.getDecorQuantity();
	 */

	@Override
	public String getBillById(int cartId)
	{
		
		CartP p=cartrepo.getById(cartId);
		
		return "bill is " + p.total();

	}

}
