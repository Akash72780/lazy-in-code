package com.dummy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dummy.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findProdByItemType(String item_cd);
	
	List<Product> findProdById(String prod_cd);
	
	List<Product> findProdByName(String prod_name);

}
