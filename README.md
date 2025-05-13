# 📚 Proyecto Biblioteca - Microservicios con Feign

Este proyecto implementa una biblioteca virtual utilizando arquitectura de microservicios con Spring Boot y comunicación entre servicios mediante OpenFeign.

## 🧩 Microservicios

- **servicio-autores**: gestiona los datos de autores, incluyendo su nombre, nacionalidad y libros escritos (por ISBN).
- **servicio-libros**: permite registrar y consultar libros. Al guardar un libro, consulta al servicio de autores para obtener los autores relacionados al ISBN.

## 🔗 Comunicación Feign

El microservicio de libros utiliza Feign para conectarse al microservicio de autores y obtener los autores de un libro para luego registrarlos.


## 🛠️ Tecnologías

- Java 17
- Spring Boot
- Spring Cloud OpenFeign
- Spring Data JPA
- MySQL


