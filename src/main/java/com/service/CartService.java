package com.service;

import java.util.List;

import com.entity.CartP;
import com.entity.CustomerReg;
import com.entity.Seed;

public interface CartService {

	CartP addProduct(CartP cart);

	String deleteProductById(int cid);

	List<CartP> getCart();

	CartP getCartById(int cartId) throws Throwable;

	String deleteCartById(int cartId);

	CartP updateCart(CartP c) throws Throwable;

	//double PrintBill();

	String getBillById(int cartId);



}
