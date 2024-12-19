package com.practic.practic.controller;

import com.practic.practic.entity.Product;
import com.practic.practic.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

        private final ProductService productService;

        public ProductController(ProductService productService) {
                this.productService = productService;
        }

        @GetMapping
        public List<Product> getAllProducts() {
                return productService.getAllProducts();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable int id) {
                Optional<Product> product = productService.getProductById(id);
                return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {
                productService.addProduct(product);
                return new ResponseEntity<>(product, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
                if (!productService.getProductById(id).isPresent()) {
                        return ResponseEntity.notFound().build();
                }
                product.setId(id);
                productService.updateProduct(product);
                return ResponseEntity.ok(product);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
                if (!productService.getProductById(id).isPresent()) {
                        return ResponseEntity.notFound().build();
                }
                productService.deleteProduct(id);
                return ResponseEntity.noContent().build();
        }
}
