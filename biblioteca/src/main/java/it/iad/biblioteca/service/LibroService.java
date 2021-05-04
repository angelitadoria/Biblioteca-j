package it.iad.biblioteca.service;

import it.iad.biblioteca.model.Libro;
import java.util.List;

public interface LibroService {
    
    List<Libro> ricercaPerCodice(String codice);
    List<Libro> ricercaJpql(String titolo, String cognome, String casaEd);
    List<Libro> ricercaJpa(String titolo, String cognome, String casaEd);
    List<Libro> aggiungi(Libro libro);
    List<Libro> modifica(Libro libro);
    List<Libro> rimuovi(Libro libro);
    List<Libro> aggiorna();
}
