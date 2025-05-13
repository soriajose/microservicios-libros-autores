package com.todocodeacademy.autores.service;

import com.todocodeacademy.autores.dto.AutorRequestDTO;
import com.todocodeacademy.autores.model.Autor;

import java.util.List;

public interface IAutorService {

    public List<Autor> getAllAutores();
    public Autor getAutorById(Long id);
    public String saveAutor(AutorRequestDTO autorRequestDTO);
    public String updateAutor(Long id, AutorRequestDTO autorRequestDTO);
    public String deleteAutor(Long id);
    public List<Autor> getAutoresByIsbn(Long isbn);

}
