package com.todocodeacademy.libros.service;

import com.todocodeacademy.libros.dto.LibroRequestDTO;
import com.todocodeacademy.libros.model.Libro;
import org.hibernate.sql.Update;

import java.util.List;

public interface ILibroService {

    public List<Libro> getLibros();
    public Libro getLibroById(Long id);
    public String updateLibro(Long id, LibroRequestDTO libroRequestDTO);
    public String saveLibro(LibroRequestDTO libro);
    public String deleteLibro(Long id);

}
