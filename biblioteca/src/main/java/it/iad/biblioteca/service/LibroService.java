package it.iad.biblioteca.service;

import it.iad.biblioteca.model.Libro;
import java.util.List;

public interface LibroService {
    
    List<Libro> ricerca(String s);
    List<Libro> aggiungi(Libro libro);
    List<Libro> modifica(Libro libro);
    List<Libro> rimuovi(Libro libro);
    List<Libro> aggiorna();
}
