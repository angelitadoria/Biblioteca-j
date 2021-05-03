package it.iad.biblioteca.repository;

import it.iad.biblioteca.model.CasaEditrice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaEditriceRepository extends JpaRepository<CasaEditrice, Long>{

    List<CasaEditrice> findByNomeContains(String criterio);
}
