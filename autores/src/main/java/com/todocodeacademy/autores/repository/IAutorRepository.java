package com.todocodeacademy.autores.repository;

import com.todocodeacademy.autores.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {

    //JPQL
    // Busco todos los autores donde el ISBN se encuentre en la lista a.libros
    @Query("SELECT a FROM Autor a WHERE :isbn MEMBER OF a.libros")
    List<Autor> findAutoresByIsbn(Long isbn);

}
