package com.dummy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.Model.Apparel;
import com.dummy.Model.ApparelProduct;
import com.dummy.Model.Book;
import com.dummy.Model.BookProduct;
import com.dummy.Model.Product;
import com.dummy.repository.ApparelRepository;
import com.dummy.repository.BookRepository;
import com.dummy.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ApparelRepository apparelRepository;
	
	@Override
	public List<BookProduct> getAllBookInfo() {
		List<BookProduct> bookProdList=new ArrayList<BookProduct>();
		BookProduct bookProduct=null;
		List<Product> allProd=productRepository.findProdByItemType("B%");
		
		for (Product product : allProd) {
			List<Book> book=bookRepository.findBookId(product.getItemId());
			if(!book.isEmpty()) {
				bookProduct=new BookProduct();
				bookProduct.setProdId(product.getProdId());
				bookProduct.setProdName(product.getProdName());
				bookProduct.setPrice(product.getPrice());
				bookProduct.setGenre(book.get(0).getGenre());
				bookProduct.setAuthor(book.get(0).getAuthor());
				bookProduct.setPublication(book.get(0).getPublication());
				bookProduct.setItemId(book.get(0).getBookId());
				bookProdList.add(bookProduct);
			}
		}
		return bookProdList;
	}
	
	@Override
	public List<ApparelProduct> getAllApparelInfo() {
		List<ApparelProduct> apparelProdList=new ArrayList<ApparelProduct>();
		ApparelProduct apparelProduct=null;
		List<Product> allProd=productRepository.findProdByItemType("A%");
		
		for (Product product : allProd) {
			List<Apparel> apparel=apparelRepository.findApparelId(product.getItemId());
			if(!apparel.isEmpty()) {
				apparelProduct=new ApparelProduct();
				apparelProduct.setProdId(product.getProdId());
				apparelProduct.setProdName(product.getProdName());
				apparelProduct.setPrice(product.getPrice());
				apparelProduct.setType(apparel.get(0).getType());
				apparelProduct.setBrand(apparel.get(0).getBrand());
				apparelProduct.setDesign(apparel.get(0).getDesign());
				apparelProduct.setItemId(apparel.get(0).getApparelId());
				apparelProdList.add(apparelProduct);
			}
		}
		return apparelProdList;
	}
	
	@Override
	public List<Product> findbyProdId(String prod_id) {
		return productRepository.findProdById(prod_id+"%");
	}
	
	@Override
	public List<Product> findbyProdName(String prod_name) {
		return productRepository.findProdByName("%"+prod_name+"%");
	}

}
