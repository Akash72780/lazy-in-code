package com.dummy.service;

import java.util.List;

import com.dummy.Model.ApparelCart;
import com.dummy.Model.BookCart;
import com.dummy.Model.Cart;
import com.dummy.Model.Product;

public interface CartService {
	
	public Cart addToCart(Product product);
	
	public void deleteFromCart(Cart cart);
	
	public void updateInCart(Cart cart);
	
	public List<Cart> findAllCart();
	
	public BookCart getOneBookInfo(Cart cart);
	
	public ApparelCart getOneApparelInfo(Cart cart);
	
	public void removeAllProduct();

}
