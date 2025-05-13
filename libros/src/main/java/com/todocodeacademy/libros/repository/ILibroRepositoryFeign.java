package com.todocodeacademy.libros.repository;

import com.todocodeacademy.libros.dto.AutorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "apiAutores", url = "http://localhost:9005/autor")
public interface ILibroRepositoryFeign {

    @GetMapping("/getAutoresByIsbn/{isbn}")
    public List<AutorDTO> getAutoresByIsbn(@PathVariable("isbn") Long isbn);

}
