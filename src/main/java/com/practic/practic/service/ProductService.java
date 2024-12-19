package com.practic.practic.service;

import com.practic.practic.entity.Product;
import com.practic.practic.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

        private final ProductRepository productRepository;

        public ProductService(ProductRepository productRepository) {
                this.productRepository = productRepository;
        }

        public List<Product> getAllProducts() {
                return productRepository.findAll();
        }


        public Optional<Product> getProductById(int id) {
                return productRepository.findById(id);
        }

        public void addProduct(Product product) {
                productRepository.save(product);
        }

        public void updateProduct(Product product) {
                productRepository.save(product);
        }

        public void deleteProduct(int id) {
                productRepository.deleteById(id);
        }
}
