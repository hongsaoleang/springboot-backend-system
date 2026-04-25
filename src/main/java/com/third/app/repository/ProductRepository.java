package com.third.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.third.app.model.Product;

public interface  ProductRepository extends JpaRepository<Product, Long>{
    
}
