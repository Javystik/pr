package com.practic.practic.controller;

import com.practic.practic.entity.ProductCategory;
import com.practic.practic.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {

        private final ProductCategoryService productCategoryService;

        public ProductCategoryController(ProductCategoryService productCategoryService) {
                this.productCategoryService = productCategoryService;
        }

        @GetMapping
        public List<ProductCategory> getAllCategories() {
                return productCategoryService.getAllCategories();
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProductCategory> getCategoryById(@PathVariable int id) {
                Optional<ProductCategory> category = productCategoryService.getCategoryById(id);
                return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<ProductCategory> createCategory(@RequestBody ProductCategory category) {
                productCategoryService.addCategory(category);
                return new ResponseEntity<>(category, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ProductCategory> updateCategory(@PathVariable int id, @RequestBody ProductCategory category) {
                if (!productCategoryService.getCategoryById(id).isPresent()) {
                        return ResponseEntity.notFound().build();
                }
                category.setId(id);
                productCategoryService.updateCategory(category);
                return ResponseEntity.ok(category);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
                if (!productCategoryService.getCategoryById(id).isPresent()) {
                        return ResponseEntity.notFound().build();
                }
                productCategoryService.deleteCategory(id);
                return ResponseEntity.noContent().build();
        }
}
