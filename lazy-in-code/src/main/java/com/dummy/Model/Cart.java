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

@Entity(name = "Cart")
@Table(name = "CART")
@DynamicUpdate
@NamedQueries(value = {
		@NamedQuery(name="Cart.findByProdid", query = "SELECT u from Cart u where u.prodId =?1")
})
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id;
	@Column(name = "PROD_NAME")
	 String prodName;
	@Column(name = "PROD_ID")
	 String prodId;
	@Column(name = "PROD_TYPE")
	 String type;
	@Column(name = "ITEM_ID")
	 String itemId;
	@Column(name = "COUNT")
	 int count;
	@Column(name = "PRICE")
	 float price;
	
	public Cart() {
		super();
	}

	

	public Cart(long id, String prodName, String prodId, String type, String itemId, int count, float price) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.prodId = prodId;
		this.type = type;
		this.itemId = itemId;
		this.count = count;
		this.price = price;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	@Override
	public String toString() {
		return "Cart [id=" + id + ", prodName=" + prodName + ", prodId=" + prodId + ", type=" + type + ", itemId="
				+ itemId + ", count=" + count + ", price=" + price + "]";
	}
	
	
}
