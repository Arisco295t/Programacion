package com.example.demo_mnf.dto;

public class ProductCreateDTO {
    private String nombre;
    private Double precio;
    private Integer stock;
    private Double costeFabricacion;
    private Long categoriaId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getCosteFabricacion() {
        return costeFabricacion;
    }

    public void setCosteFabricacion(Double costeFabricacion) {
        this.costeFabricacion = costeFabricacion;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
