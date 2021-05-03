package it.iad.biblioteca.repository;

import it.iad.biblioteca.model.PosizioneScaffale;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosizioneScaffaleRepository extends JpaRepository<PosizioneScaffale, Long>{

    List<PosizioneScaffale> findByCodiceContains(String criterio);
}
