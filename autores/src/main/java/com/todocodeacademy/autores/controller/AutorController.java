package com.todocodeacademy.autores.controller;

import com.todocodeacademy.autores.dto.AutorRequestDTO;
import com.todocodeacademy.autores.model.Autor;
import com.todocodeacademy.autores.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private IAutorService iAutorService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        try {
            List<Autor> lista = iAutorService.getAllAutores();
            if (lista.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getAutorById(@PathVariable Long id) {
        try {
            Autor autor = iAutorService.getAutorById(id);
            if (autor == null) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(autor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/save")
    private ResponseEntity<?> saveAutor(@RequestBody AutorRequestDTO autor) {
        try {
            return ResponseEntity.ok(iAutorService.saveAutor(autor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getAutoresByIsbn/{isbn}")
    public ResponseEntity<?> getAutoresByIsbn(@PathVariable("isbn") Long isbn) {
        try {
            List<Autor> lista = iAutorService.getAutoresByIsbn(isbn);
            if (lista.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateAutor(@PathVariable("id") Long id, @RequestBody AutorRequestDTO autorRequestDTO) {
        try {
            return ResponseEntity.ok(iAutorService.updateAutor(id, autorRequestDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAutor(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(iAutorService.deleteAutor(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
