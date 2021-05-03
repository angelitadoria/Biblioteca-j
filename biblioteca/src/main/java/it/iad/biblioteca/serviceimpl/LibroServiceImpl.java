package it.iad.biblioteca.serviceimpl;

import it.iad.biblioteca.model.Libro;
import it.iad.biblioteca.repository.LibroRepository;
import it.iad.biblioteca.service.LibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService{
    
    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<Libro> ricerca(String s) {
        return null;
    }

    @Override
    public List<Libro> aggiungi(Libro libro) {
        libroRepository.save(libro);
        return aggiorna();
    }

    @Override
    public List<Libro> modifica(Libro libro) {
        libroRepository.save(libro);
        return aggiorna();
    }

    @Override
    public List<Libro> rimuovi(Libro libro) {
        libroRepository.delete(libro);
        return aggiorna();
    }

    @Override
    public List<Libro> aggiorna() {
        return libroRepository.findAll(); 
    }

}
