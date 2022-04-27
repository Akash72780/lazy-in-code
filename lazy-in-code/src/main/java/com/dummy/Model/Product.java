package com.dummy.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "Product")
@Table(name = "PRODUCT")
@DynamicUpdate
@NamedQueries(value = {
		@NamedQuery(name="Product.findProdByItemType", query = "SELECT u from Product u where u.itemId like ?1"),
		@NamedQuery(name="Product.findProdById", query = "SELECT u from Product u where u.prodId like ?1"),
		@NamedQuery(name="Product.findProdByName", query = "SELECT u from Product u where u.prodName like ?1")
})
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id;
	
	@Column(name = "PROD_ID")
	 String prodId;
	
	@Column(name = "PROD_NAME")
	String prodName;
	
	@Column(name = "PRICE")
	 float price;
	
	@Column(name = "ITEM_ID")
	 String itemId;
	
	public Product() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Product(long id, String prodId, String prodName, long price, String itemId) {
		super();
		this.id = id;
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.itemId = itemId;
	}
}
