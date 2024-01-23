package com.demo.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.product.entity.Category;
import com.demo.product.entity.Product;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {

	public List<Product> findByCategory(Category category);
}

