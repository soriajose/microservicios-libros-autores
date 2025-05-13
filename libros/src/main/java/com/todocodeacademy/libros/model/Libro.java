package com.todocodeacademy.libros.model;

import com.todocodeacademy.libros.dto.AutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "libro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anio_publicacion")
    private String anio_publicacion;

    @Column(name = "descripcion")
    private String descripcion;

   @ElementCollection(fetch = FetchType.EAGER)
    private List<String> autores;

}
