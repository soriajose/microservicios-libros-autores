package com.todocodeacademy.autores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @ElementCollection
    private List<Long> libros;

}
