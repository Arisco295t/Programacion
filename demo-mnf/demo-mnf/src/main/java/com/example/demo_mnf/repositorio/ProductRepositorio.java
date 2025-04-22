package com.example.demo_mnf.repositorio;


import com.example.demo_mnf.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositorio extends JpaRepository<Producto,
        Long> {
}



