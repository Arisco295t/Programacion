package com.example.demo_mnf.servicio;

import com.example.demo_mnf.model.Producto;
import com.example.demo_mnf.repositorio.ProductRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicio {
    @Autowired
    private ProductRepositorio productRepositorio;

    public List<Producto> listarProductos() {
        // Devuelve todos los registros de la tabla 'producto'
        return productRepositorio.findAll();
    }

    public Producto buscarProducto(Long id) {


        Producto p = productRepositorio.findById(id).orElse(null);
        return p;
    }

    public Producto guardarProducto(Producto p) {
        return productRepositorio.save(p);
    }

    public boolean borrarProducto(Long id) {
        // Verifica si existe
        if (productRepositorio.existsById(id)) {
            productRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}

