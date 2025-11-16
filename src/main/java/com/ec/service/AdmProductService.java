package com.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.entity.AdmProduct;
import com.ec.repository.AdmProductRepository;

@Service
public class AdmProductService {
	
	@Autowired
    private  AdmProductRepository productRepo;

    public List<AdmProduct> getAllProducts() {
        return productRepo.findAll();
    }

    public AdmProduct saveProduct(AdmProduct product) {
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public AdmProduct getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

}
