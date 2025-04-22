package com.example.demo_mnf.repositorio;
import com.example.demo_mnf.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria,
        Long> {
    }

