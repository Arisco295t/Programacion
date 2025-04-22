package com.example.demo_mnf.Controller;

import com.example.demo_mnf.dto.ProductCreateDTO;
import com.example.demo_mnf.dto.ProductDTO;
import com.example.demo_mnf.model.Categoria;
import com.example.demo_mnf.model.Producto;
import com.example.demo_mnf.servicio.CategoriaServicio;
import com.example.demo_mnf.servicio.ProductServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ProductoController {
    @Autowired
    private ProductServicio productServicio;


    // Crear producto usando DTO de entrada (ProductoCreateDTO)
    @PostMapping
    public ResponseEntity<ProductDTO> crearProducto(@RequestBody
                                                    ProductCreateDTO dto) {
        // Convertir DTO -> Entidad
        Producto p = new Producto();
        p.setName(dto.getNombre());
        p.setPrecio(dto.getPrecio());
        p.setStock(dto.getStock());
        p.setCosteFabricacion(dto.getCosteFabricacion());

        // Asignar categoría si se indica
        if (dto.getCategoriaId() != null) {
            Categoria c =
                    CategoriaServicio.buscarCategoria(dto.getCategoriaId());
            p.setCategoria(c);
        }

        Producto guardado = productServicio.guardarProducto(p);

        // Convertir Entidad -> DTO
        ProductDTO respuesta = convertirAProductoDTO(guardado);

        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    // Listar productos (mostrando DTO sin stock ni costeFabricacion)
    @GetMapping
    public ResponseEntity<List<ProductDTO>> listarProductos() {
        List<Producto> productos = productServicio.listarProductos();
        List<ProductDTO> listaDTO = new ArrayList<>();
        for (Producto p : productos) {
            listaDTO.add(convertirAProductoDTO(p));
        }
        return ResponseEntity.ok(listaDTO);
    }

    // Obtener un producto por ID con DTO
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProducto(@PathVariable Long
                                                           id) {
        Producto p = productServicio.buscarProducto(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO dto = convertirAProductoDTO(p);
        return ResponseEntity.ok(dto);
    }

    // Actualizar un producto usando DTO de entrada
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> actualizarProducto(@PathVariable
                                                             Long id, @RequestBody ProductCreateDTO dto) { Producto existente = productServicio.buscarProducto(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        // Actualizar campos
        existente.setName(dto.getNombre());
        existente.setPrecio(dto.getPrecio());
        existente.setStock(dto.getStock());
        existente.setCosteFabricacion(dto.getCosteFabricacion());

        if (dto.getCategoriaId() != null) {

            CategoriaServicio.buscarCategoria(id);
            Categoria c =
                    CategoriaServicio.buscarCategoria(dto.getCategoriaId());
            existente.setCategoria(c);
        } else {
            existente.setCategoria(null);
        }

        Producto actualizado =
                productServicio.guardarProducto(existente);
        ProductDTO respuesta = convertirAProductoDTO(actualizado);
        return ResponseEntity.ok(respuesta);
    }

    // Borrar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable Long id) {
        boolean borrado = productServicio.borrarProducto(id);
        if (borrado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ----------------------------------------------
    // Convertir Entidad -> DTO
    private ProductDTO convertirAProductoDTO(Producto p) {
        ProductDTO dto = new ProductDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getName());
        dto.setPrecio(p.getPrecio());
        if (p.getCategoria() != null) {
            dto.setCategoriaNombre(p.getCategoria().getNombre());
        }
        return dto;
    }
}
