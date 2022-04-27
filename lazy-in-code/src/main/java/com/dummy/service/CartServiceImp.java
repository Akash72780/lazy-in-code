package com.dummy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.Model.Apparel;
import com.dummy.Model.ApparelCart;
import com.dummy.Model.Book;
import com.dummy.Model.BookCart;
import com.dummy.Model.Cart;
import com.dummy.Model.Product;
import com.dummy.repository.ApparelRepository;
import com.dummy.repository.BookRepository;
import com.dummy.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ApparelRepository apparelRepository;
	
	@Override
	public Cart addToCart(Product product) {
		Cart newCart=null;
		Cart oldCart=cartRepository.findByProdid(product.getProdId());
		
		if(oldCart!=null) {
			oldCart.setCount(oldCart.getCount()+1);
			return cartRepository.save(oldCart);
		}else{
			newCart=new Cart();
			newCart.setProdId(product.getProdId());
			newCart.setProdName(product.getProdName());
			newCart.setCount(1);
			newCart.setPrice(product.getPrice());
			newCart.setItemId(product.getItemId());
			newCart.setType(product.getItemId().startsWith("A")?"Apparel":"Book");
			return cartRepository.save(newCart);
		}
	}
	
	@Override
	public void deleteFromCart(Cart cart) {
		cartRepository.delete(cart);
	}
	
	@Override
	public void updateInCart(Cart cart) {
		if(cart.getCount()==0)
			cartRepository.delete(cart);
		else
			cartRepository.save(cart);
	}
	
	@Override
	public List<Cart> findAllCart() {
		return (List<Cart>) cartRepository.findAll();
	}
	
	@Override
	public BookCart getOneBookInfo(Cart cart) {
		BookCart bookCart=null;
		
		List<Book> book=bookRepository.findBookId(cart.getItemId());
		if(!book.isEmpty()) {
			bookCart=new BookCart();
			bookCart.setProdId(cart.getProdId());
			bookCart.setProdName(cart.getProdName());
			bookCart.setPrice(cart.getPrice());
			bookCart.setCount(cart.getCount());
			bookCart.setGenre(book.get(0).getGenre());
			bookCart.setAuthor(book.get(0).getAuthor());
			bookCart.setPublication(book.get(0).getPublication());
			bookCart.setItemId(book.get(0).getBookId());
		}
		return bookCart;
	}
	
	@Override
	public ApparelCart getOneApparelInfo(Cart cart) {
		ApparelCart apparelCart=null;

		List<Apparel> apparel=apparelRepository.findApparelId(cart.getItemId());
		if(!apparel.isEmpty()) {
			apparelCart=new ApparelCart();
			apparelCart.setProdId(cart.getProdId());
			apparelCart.setProdName(cart.getProdName());
			apparelCart.setPrice(cart.getPrice());
			apparelCart.setCount(cart.getCount());
			apparelCart.setType(apparel.get(0).getType());
			apparelCart.setBrand(apparel.get(0).getBrand());
			apparelCart.setDesign(apparel.get(0).getDesign());
			apparelCart.setItemId(apparel.get(0).getApparelId());
		}
		return apparelCart;
	}
	
	@Override
	public void removeAllProduct() {
		cartRepository.deleteAll();
	}

}
