package it.iad.biblioteca.repository;

import it.iad.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    
    
}
