package it.iad.biblioteca.service;

import it.iad.biblioteca.model.CasaEditrice;
import java.util.List;

public interface CasaEditriceService {

    List<CasaEditrice> ricerca(String s);
    List<CasaEditrice> aggiungi(CasaEditrice ce);
    List<CasaEditrice> modifica(CasaEditrice ce);
    List<CasaEditrice> rimuovi(CasaEditrice ce);
    List<CasaEditrice> aggiorna();
}
