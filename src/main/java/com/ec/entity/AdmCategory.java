package com.ec.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class AdmCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "acategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdmProduct> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AdmProduct> getProducts() {
		return products;
	}

	public void setProducts(List<AdmProduct> products) {
		this.products = products;
	}

	public AdmCategory(Long id, String name, List<AdmProduct> products) {
		
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public AdmCategory() {
		
	}
    
    


}
