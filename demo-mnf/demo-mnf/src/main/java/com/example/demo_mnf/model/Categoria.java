package com.example.demo_mnf.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nombre;
    private String descripcion;

    // Relación bidireccional con Producto
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Producto> Product;

    // Constructores, Getters, Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProduct() {
        return Product;
    }

    public void setProduct(List<Producto> product) {
        Product = product;
    }
}

