package com.dummy.service;

import java.util.List;

import com.dummy.Model.ApparelProduct;
import com.dummy.Model.BookProduct;
import com.dummy.Model.Product;

public interface ProductService {
	
	public List<BookProduct> getAllBookInfo();
	
	public List<ApparelProduct> getAllApparelInfo();
	
	public List<Product> findbyProdId(String prod_id);
	
	public List<Product> findbyProdName(String prod_name);

}
