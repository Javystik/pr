package com.practic.practic.service;

import com.practic.practic.entity.ProductCategory;
import com.practic.practic.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

        private final ProductCategoryRepository productCategoryRepository;

        public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
                this.productCategoryRepository = productCategoryRepository;
        }

        public List<ProductCategory> getAllCategories() {
                return productCategoryRepository.findAll();
        }

        public Optional<ProductCategory> getCategoryById(int id) {
                return productCategoryRepository.findById(id);
        }

        public void addCategory(ProductCategory category) {
                productCategoryRepository.save(category);
        }

        public void updateCategory(ProductCategory category) {
                productCategoryRepository.save(category);
        }

        public void deleteCategory(int id) {
                productCategoryRepository.deleteById(id);
        }
}
