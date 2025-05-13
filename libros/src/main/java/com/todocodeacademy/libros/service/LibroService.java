package com.todocodeacademy.libros.service;

import com.todocodeacademy.libros.dto.AutorDTO;
import com.todocodeacademy.libros.dto.LibroRequestDTO;
import com.todocodeacademy.libros.exception.LibroException;
import com.todocodeacademy.libros.model.Libro;
import com.todocodeacademy.libros.repository.ILibroRepository;
import com.todocodeacademy.libros.repository.ILibroRepositoryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements ILibroService {

    @Autowired
    private ILibroRepositoryFeign iLibroRepositoryFeign;
    @Autowired
    private ILibroRepository iLibroRepository;

    @Override
    public List<Libro> getLibros() {
        try {
            return iLibroRepository.findAll();
        } catch (Exception e) {
            throw new LibroException("Error al obtener la lista de libros - Error: " + e.getMessage());
        }
    }

    @Override
    public Libro getLibroById(Long id) {
        try {
            Optional<Libro> libroOptional = iLibroRepository.findById(id);
            return libroOptional.orElse(null);
        } catch (Exception e) {
            throw new LibroException("Error al obtener el libro - Error: " + e.getMessage());
        }
    }

    @Override
    public String updateLibro(Long id, LibroRequestDTO libroRequestDTO) {
        try {
            Optional<Libro> libroOptional = iLibroRepository.findById(id);
            if (libroOptional.isPresent()) {
                Libro libro = libroOptional.get();
                libro.setIsbn(libroRequestDTO.getIsbn());
                libro.setTitulo(libroRequestDTO.getTitulo());
                libro.setDescripcion(libroRequestDTO.getDescripcion());
                libro.setAnio_publicacion(libroRequestDTO.getAnio_publicacion());
                iLibroRepository.save(libro);
                return "El libro se ha actualizado correctamente";
            } else {
                return "El libro no se ha encontrado";
            }
        } catch (Exception e) {
            throw new LibroException("Error al actualizar el libro - Error: " + e.getMessage());
        }
    }

    @Override
    public String saveLibro(LibroRequestDTO libroDTO) {
        try {
            List<AutorDTO> autorDTOList = iLibroRepositoryFeign.getAutoresByIsbn(libroDTO.getIsbn());
            if (autorDTOList.isEmpty()) {
                return "El libro no se registro. No existe autor con ese ISBN: " + libroDTO.getIsbn();
            }
            List<String> autores = new ArrayList<>();
            Libro libro = new Libro();
            for (AutorDTO a : autorDTOList) {
                autores.add("Nombre completo: " + a.getNombreCompleto() + " - Nacionalidad: " + a.getNacionalidad());
            }
            libro.setIsbn(libroDTO.getIsbn());
            libro.setTitulo(libroDTO.getTitulo());
            libro.setAnio_publicacion(libroDTO.getAnio_publicacion());
            libro.setDescripcion(libroDTO.getDescripcion());
            libro.setAutores(autores);
            iLibroRepository.save(libro);
            return "El libro se ha registrado correctamente";
        } catch (Exception e) {
            throw new LibroException("Error al guardar el libro - Error: " + e.getMessage());
        }
    }

    @Override
    public String deleteLibro(Long id) {
        try {
            Optional<Libro> libroOptional = iLibroRepository.findById(id);
            if (libroOptional.isPresent()) {
                Libro libro = libroOptional.get();
                iLibroRepository.delete(libro);
                return "El libro fue eliminado con éxito!";
            } else {
                return "El libro no se ha eliminado ya que no existe";
            }
        } catch (Exception e) {
            throw new LibroException("Error al eliminar el libro - Error: " + e.getMessage());
        }
    }
}
