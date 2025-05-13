package com.todocodeacademy.autores.service;

import com.todocodeacademy.autores.dto.AutorRequestDTO;
import com.todocodeacademy.autores.exception.AutorException;
import com.todocodeacademy.autores.model.Autor;
import com.todocodeacademy.autores.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IAutorService {

    @Autowired
    private IAutorRepository iAutorRepository;

    @Override
    public List<Autor> getAllAutores() {
        try {
            return iAutorRepository.findAll();
        } catch (Exception e) {
            throw new AutorException("Error al obtener el listado de autores - Error: " + e.getMessage());
        }
    }

    @Override
    public Autor getAutorById(Long id) {
        try {
            Optional<Autor> autor = iAutorRepository.findById(id);
            return autor.orElse(null);
        } catch (Exception e) {
            throw new AutorException("Error al buscar el Autor - Error: " + e.getMessage());
        }
    }

    @Override
    public String saveAutor(AutorRequestDTO autorRequestDTO) {
        try {
            Autor autor = new Autor();
            autor.setNombreCompleto(autorRequestDTO.getNombreCompleto());
            autor.setFechaNacimiento(autorRequestDTO.getFechaNacimiento());
            autor.setNacionalidad(autorRequestDTO.getNacionalidad());
            autor.setLibros(autorRequestDTO.getLibros());
            iAutorRepository.save(autor);
            return "El Autor se guardo correctamente";
        } catch (Exception e) {
            throw new AutorException("Error al guardar el Autor - Error: " + e.getMessage());
        }
    }

    @Override
    public String updateAutor(Long id, AutorRequestDTO autorRequestDTO) {
        try {
            Optional<Autor> autorOptional = iAutorRepository.findById(id);
            if (autorOptional.isPresent()) {
                Autor autor = autorOptional.get();
                autor.setNombreCompleto(autorRequestDTO.getNombreCompleto());
                autor.setFechaNacimiento(autorRequestDTO.getFechaNacimiento());
                autor.setNacionalidad(autorRequestDTO.getNacionalidad());
                autor.setLibros(autorRequestDTO.getLibros());
                iAutorRepository.save(autor);
                return "Autor actualizado correctamente.";
            } else {
                return "No se encontró el autor con ID: " + id;
            }
        } catch (Exception e) {
            throw new AutorException("Error al actualizar el Autor - Error: " + e.getMessage());
        }
    }

    @Override
    public String deleteAutor(Long id) {
        try {
            Optional<Autor> autorOptional = iAutorRepository.findById(id);
            if (autorOptional.isPresent()) {
                iAutorRepository.delete(autorOptional.get());
                return "Autor eliminado correctamente.";
            } else {
                return "El Autor con ID: " + id + " no existe";
            }
        } catch (Exception e) {
            throw new AutorException("Error al eliminar el Autor - Error: " + e.getMessage());
        }
    }

    @Override
    public List<Autor> getAutoresByIsbn(Long isbn) {
        try {
            return iAutorRepository.findAutoresByIsbn(isbn);
        } catch (Exception e) {
            throw new AutorException("Error al obtener el listado de autores - Error: " + e.getMessage());
        }
    }
}
