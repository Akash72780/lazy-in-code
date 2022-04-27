package com.dummy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.dummy.Model.Product;
import com.dummy.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testFindItemType() {
		List<Product> listOfProduct=productRepository.findProdByItemType("B%");
		
		assertThat(listOfProduct.size(), is(greaterThanOrEqualTo(0)));
	}
	
	@Test
	public void testFindProdId() {
		List<Product> listOfProduct=productRepository.findProdById("P10%");
		
		assertThat(listOfProduct.size(), is(greaterThanOrEqualTo(0)));
	}
	
	@Test
	public void testFindProdName() {
		List<Product> listOfProduct=productRepository.findProdByName("%Serafina Women%");
		
		assertThat(listOfProduct.size(), is(greaterThanOrEqualTo(0)));
	}

}
