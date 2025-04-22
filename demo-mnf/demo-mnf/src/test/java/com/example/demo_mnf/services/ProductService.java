package com.example.demo_mnf.services;

import com.example.demo_mnf.model.Product;
import com.example.demo_mnf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

    @Service
    public class ProductService {
        @Autowired
        private ProductService productRepository;

        public List<Product> listProducts() {

            return productRepository.findAll();
        }
        public Product findById(Integer id){
            Product p = productRepository.findById(id).orElse(null);
            return p;
        }

        public Product guardarProducto(Product p) {
            // Inserta o actualiza (si p tiene un ID existente)
            return productRepository.save(p);
        }
        public boolean deleteProduct (Long id) {
            // Verifica si existe
            if (productRepository.existsById(id)) {
                productRepository.deletById(id);
                return true;
            }
            return false;
        }
    }

