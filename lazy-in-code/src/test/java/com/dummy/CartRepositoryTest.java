package com.dummy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dummy.Model.Cart;
import com.dummy.repository.CartRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class CartRepositoryTest {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Test
	public void testFindItemType() {
		Cart result=cartRepository.findByProdid("P110");
		if(result==null)
			System.out.println("Need to add product in cart");
		else
			System.out.println("Product name "+result.getProdName());
	}

}
