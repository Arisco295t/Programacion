package com.example.demo_mnf.Controller;
import com.example.demo_mnf.dto.CategoriaDTO;
import com.example.demo_mnf.model.Categoria;
import com.example.demo_mnf.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaServicio.listarCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long
                                                          id) {
        Categoria c = categoriaServicio.buscarCategoria(id);
        if (c != null) {
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria c) {
        return categoriaServicio.guardarCategoria(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCategoria(@PathVariable Long id) {
        boolean borrada = categoriaServicio.borrarCategoria(id);
        if (borrada) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private CategoriaDTO convertirACategoriaDTO(Categoria c) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setDescripcion(c.getDescripcion());
        return dto;
    }
}

