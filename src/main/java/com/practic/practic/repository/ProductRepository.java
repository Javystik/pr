package com.practic.practic.repository;

import com.practic.practic.entity.Product;
import com.practic.practic.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
