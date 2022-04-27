package com.dummy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dummy.Model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{
	Cart findByProdid(String prodId);
}
