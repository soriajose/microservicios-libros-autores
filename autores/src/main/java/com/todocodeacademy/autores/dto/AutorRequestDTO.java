package com.todocodeacademy.autores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorRequestDTO {
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private List<Long> libros;
}
