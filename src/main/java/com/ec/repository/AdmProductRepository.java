package com.ec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.entity.*;
@Repository
public interface AdmProductRepository extends JpaRepository<AdmProduct, Long> {
	
	List<AdmProduct> findByAcategoryId(Long categoryId);
	
	
	
	
	
	// 🔍 Search by product name
    @Query("SELECT p FROM AdmProduct p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<AdmProduct> searchByName(@Param("keyword") String keyword);


}
