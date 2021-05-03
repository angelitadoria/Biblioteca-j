package it.iad.biblioteca.repository;

import it.iad.biblioteca.model.Autore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Long>{

    List<Autore> findByCognomeContains(String criterio);
}
