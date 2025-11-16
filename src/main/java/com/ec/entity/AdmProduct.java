package com.ec.entity;

import com.ec.entity.AdmCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;

@Entity
public class AdmProduct {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private double price;
	    private String description;
	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private AdmCategory acategory;
	    private String imagePath;
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
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
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public AdmCategory getCategory() {
			return acategory;
		}
		public void setCategory(AdmCategory category) {
			this.acategory = category;
		}
		public AdmProduct(Long id, String name, double price, String description, AdmCategory category,String imagePath) {
			
			this.id = id;
			this.name = name;
			this.price = price;
			this.description = description;
			this.acategory = category;
			this.imagePath=imagePath;
		}
		public AdmProduct() {
			
		}
	    
	    

}