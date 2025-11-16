package com.ec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.entity.AdmCategory;

@Repository
public interface AdmCategoryRepository extends JpaRepository<AdmCategory, Long> {
}

