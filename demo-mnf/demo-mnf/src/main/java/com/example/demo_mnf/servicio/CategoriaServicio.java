package com.example.demo_mnf.servicio;

import com.example.demo_mnf.model.Categoria;
import com.example.demo_mnf.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServicio {
    @Autowired
    private static CategoriaRepositorio categoriaRepositorio;
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.findAll();
    }

    public static Categoria buscarCategoria(Long id) {
        return categoriaRepositorio.findById(id).orElse(null);
    }

    public Categoria guardarCategoria(Categoria c) {
        return categoriaRepositorio.save(c);
    }

    public boolean borrarCategoria(Long id) {
        if (categoriaRepositorio.existsById(id)) {
            categoriaRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}

