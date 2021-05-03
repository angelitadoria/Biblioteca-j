package it.iad.biblioteca.service;

import it.iad.biblioteca.model.Autore;
import java.util.List;

public interface AutoreService {

    List<Autore> ricerca(String s);
    List<Autore> aggiungi(Autore autore);
    List<Autore> modifica(Autore autore);
    List<Autore> rimuovi(Autore autore);
    List<Autore> aggiorna();
}
