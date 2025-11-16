package com.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ec.repository.AdmCategoryRepository;
import com.ec.repository.AdmProductRepository;
import com.ec.service.AdmCategoryService;
import com.ec.service.AdmProductService;

@Controller
public class UserAllSeeController {
	
	@Autowired
	private AdmProductRepository productRepository;

	@Autowired
	private AdmCategoryRepository categoryRepository;

	@GetMapping("/")
	public String viewAllProducts(Model model) {
	    model.addAttribute("categories", categoryRepository.findAll());
	    model.addAttribute("products", productRepository.findAll());
	    return "home";
	}

	@GetMapping("/category/{id}")
	public String viewProductsByCategory(@PathVariable Long id, Model model) {
	    model.addAttribute("categories", categoryRepository.findAll());
	    model.addAttribute("products", productRepository.findByAcategoryId(id));
	    return "home";
	}

}
