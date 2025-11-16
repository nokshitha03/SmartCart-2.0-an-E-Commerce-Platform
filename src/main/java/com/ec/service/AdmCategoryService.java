package com.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.entity.AdmCategory;
import com.ec.repository.AdmCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdmCategoryService {
	
	
	

		@Autowired
	    private  AdmCategoryRepository categoryRepo;

	    public List<AdmCategory> getAllCategories() {
	        return categoryRepo.findAll();
	    }

	    public AdmCategory saveCategory(AdmCategory category) {
	        return categoryRepo.save(category);
	    }

	    public void deleteCategory(Long id) {
	        categoryRepo.deleteById(id);
	    }

	    public AdmCategory getCategoryById(Long id) {
	        return categoryRepo.findById(id).orElse(null);
	    }
	}


