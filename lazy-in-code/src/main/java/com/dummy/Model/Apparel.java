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

@Entity(name = "Apparel")
@Table(name = "APPAREL")
@DynamicUpdate
@NamedQueries(value = {
		@NamedQuery(name="Apparel.findApparelId", query = "SELECT u from Apparel u where u.apparelId =?1")
})
public class Apparel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id;
	
	@Column(name = "APPAREL_ID")
	 String apparelId;
	
	@Column(name = "TYPE")
	String type;
	
	@Column(name = "BRAND")
	String brand;
	
	@Column(name = "DESIGN")
	 String design;

	public Apparel(long id, String apparelId, String type, String brand, String design) {
		super();
		this.id = id;
		this.apparelId = apparelId;
		this.type = type;
		this.brand = brand;
		this.design = design;
	}

	public Apparel() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApparelId() {
		return apparelId;
	}

	public void setApparelId(String apparelId) {
		this.apparelId = apparelId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}
	
	

}
