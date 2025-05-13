package com.todocodeacademy.libros.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroRequestDTO {

    private Long isbn;
    private String titulo;
    private String anio_publicacion;
    private String descripcion;

}
