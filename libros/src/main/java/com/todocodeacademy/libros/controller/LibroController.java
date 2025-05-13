package com.todocodeacademy.libros.controller;

import com.todocodeacademy.libros.dto.LibroRequestDTO;
import com.todocodeacademy.libros.model.Libro;
import com.todocodeacademy.libros.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private ILibroService iLibroService;

    @GetMapping("/list")
    public ResponseEntity<?> getLibros() {
        try {
            List<Libro> libroList = iLibroService.getLibros();
            if (libroList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(libroList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getLibroById(@PathVariable Long id) {
        try {
            Libro libro = iLibroService.getLibroById(id);
            if (libro == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLibro(@PathVariable("id") Long id, @RequestBody LibroRequestDTO libroRequestDTO) {
        try {
            return ResponseEntity.ok(iLibroService.updateLibro(id, libroRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveLibro(@RequestBody LibroRequestDTO libro) {
        try {
            return ResponseEntity.ok(iLibroService.saveLibro(libro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(iLibroService.deleteLibro(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
