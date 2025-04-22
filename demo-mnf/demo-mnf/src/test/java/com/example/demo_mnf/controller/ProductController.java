package com.example.demo_mnf.controller;

import com.example.demo_mnf.model.Product;
import com.example.demo_mnf.model.Producto;
import com.example.demo_mnf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {
    @RestController
    public class productController {
        @Autowired
        private ProductService productService;

        @GetMapping("/product")
        public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = ProductService.listProducts();
        return new ResponseEntity.ok(Product);
    }

        @GetMapping("/product/{id}")
        public ResponseEntity<Product> getProduct(@PathVariable Integer id)
        {
        Product product = productService.findById(id);
        if (product == null) {
        return ResponseEntity.ok(p);

        }
        return new ResponseEntity.notFound().build();
    }


        @PostMapping("/product")
        public ResponseEntity<?> addProduct(@RequestBody Product product) {

                productService.save(product);
                return new ResponseEntity<>(product, HttpStatus.CREATED);
            }



        @PutMapping("/product/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product p) {
                Product currentProduct = productService.findById(id);

                if (currentProduct != null) {
                    currentProduct.setName(p.getName());
                    currentProduct.setPrice(p.getPrice());
                    //Guardar
                    Producto updatedProduct = productService.saveProduct(currentProduct);
                    return ResponseEntity.ok(updated);
                }
                return ResponseEntity.notFound().build();
            }


            @DeleteMapping("/product/{id}")
            public ResponseEntity<Void> deleteProduct (@PathVariable Long id) {
                boolean delete = ProductService.deleteById(id);
                if (delete) {
                    return ResponseEntity.noContent().build();
                }
                return ResponseEntity.notFound().build();
            }
        }

