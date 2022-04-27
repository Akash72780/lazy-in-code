package com.dummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.Model.ApparelProduct;
import com.dummy.Model.BookProduct;
import com.dummy.Model.Product;
import com.dummy.service.ProductService;

@RestController
@RequestMapping("api/v1/")
public class ProductController {

	@Autowired
	private ProductService productServiceImp;

	@RequestMapping(value = "book", method = RequestMethod.GET)
	 public List<BookProduct> listOfProduct(){
		 return productServiceImp.getAllBookInfo();
	 }

	@RequestMapping(value = "apparel", method = RequestMethod.GET)
	 public List<ApparelProduct> listOfApparel(){
		 return productServiceImp.getAllApparelInfo();
	 }

	@RequestMapping(value = "product/id/{name}",method = RequestMethod.GET)
	public List<Product> getId(@PathVariable String name) {
		return productServiceImp.findbyProdId(name);
	}

	@RequestMapping(value = "product/name/{name}",method = RequestMethod.GET)
	public List<Product> getName(@PathVariable String name) {
		return productServiceImp.findbyProdName(name);
	}

}
