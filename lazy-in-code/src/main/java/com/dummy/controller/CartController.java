package com.dummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.Model.ApparelCart;
import com.dummy.Model.BookCart;
import com.dummy.Model.Cart;
import com.dummy.Model.Product;
import com.dummy.service.CartService;

@RestController
@RequestMapping("api/v2/")
public class CartController {
	
	@Autowired
	private CartService cartServiceImp;

	@RequestMapping(value = "cart/add",method = RequestMethod.POST)
	public Cart addToCart(@RequestBody Product product) {
		return cartServiceImp.addToCart(product);
	}

	@RequestMapping(value = "cart/delete",method = RequestMethod.POST)
	public void deleteFromCart(@RequestBody Cart cart) {
		cartServiceImp.deleteFromCart(cart);
	}

	@RequestMapping(value = "cart/update",method = RequestMethod.POST)
	public void updateInCart(@RequestBody Cart cart) {
		cartServiceImp.updateInCart(cart);
	}

	@RequestMapping(value = "cart/view/book",method = RequestMethod.POST)
	public BookCart viewBookCart(@RequestBody Cart cart) {
		return cartServiceImp.getOneBookInfo(cart);
	}

	@RequestMapping(value = "cart/view/apparel",method = RequestMethod.POST)
	public ApparelCart viewApparelCart(@RequestBody Cart cart) {
		return cartServiceImp.getOneApparelInfo(cart);
	}

	@RequestMapping(value = "cart",method = RequestMethod.GET)
	public List<Cart> findAllCart() {
		return cartServiceImp.findAllCart();
	}

	@RequestMapping(value = "cart",method = RequestMethod.DELETE)
	public void deleteAllCart() {
		cartServiceImp.removeAllProduct();
	}
}
