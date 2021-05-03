package it.iad.biblioteca.serviceimpl;

import it.iad.biblioteca.model.Autore;
import it.iad.biblioteca.repository.AutoreRepository;
import it.iad.biblioteca.service.AutoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoreServiceImpl implements AutoreService{
    
    @Autowired
    AutoreRepository autoreRepository;
    
    @Override
    public List<Autore> ricerca(String s) {
        return autoreRepository.findByCognomeContains(s);
    }

    @Override
    public List<Autore> aggiungi(Autore autore) {
        autoreRepository.save(autore);
        return aggiorna();
    }

    @Override
    public List<Autore> modifica(Autore autore) {
        autoreRepository.save(autore);
        return aggiorna();
    }

    @Override
    public List<Autore> rimuovi(Autore autore) {
        autoreRepository.delete(autore);
        return aggiorna();
    }

    @Override
    public List<Autore> aggiorna() {
        return autoreRepository.findAll(); 
    }

}
