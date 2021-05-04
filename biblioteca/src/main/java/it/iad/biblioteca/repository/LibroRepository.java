package it.iad.biblioteca.repository;

import it.iad.biblioteca.model.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    
    @Query("select l from Libro l"
            + " join l.autori a"
            + " join l.casaEditrice ce"
            + " join l.posizioneScaffale p"
            + " where l.titolo like %:titolo%"
            + " and a.cognome like %:cognome%"
            + " and ce.nome like %:casaEd%")
    List<Libro> trovaLibro(@Param("titolo") String titolo, 
                           @Param("cognome") String cognome,
                           @Param("casaEd") String casaEd);
    
    List<Libro> findByTitoloContainsAndAutori_cognomeContainsAndCasaEditrice_nomeContains(
                String titolo, String cognome, String nome);
    
    List<Libro> findByCodiceContains(String codice);
}
