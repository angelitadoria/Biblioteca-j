package it.iad.biblioteca.serviceimpl;

import it.iad.biblioteca.model.CasaEditrice;
import it.iad.biblioteca.repository.CasaEditriceRepository;
import it.iad.biblioteca.service.CasaEditriceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasaEditriceServiceImpl implements CasaEditriceService{

    @Autowired
    CasaEditriceRepository casaEditriceRepository;
    
    @Override
    public List<CasaEditrice> ricerca(String s) {
        return casaEditriceRepository.findByNomeContains(s);
    }

    @Override
    public List<CasaEditrice> aggiungi(CasaEditrice ce) {
        casaEditriceRepository.save(ce);
        return aggiorna();
    }

    @Override
    public List<CasaEditrice> modifica(CasaEditrice ce) {
        casaEditriceRepository.save(ce);
        return aggiorna();
    }

    @Override
    public List<CasaEditrice> rimuovi(CasaEditrice ce) {
        casaEditriceRepository.delete(ce);
        return aggiorna();
    }

    @Override
    public List<CasaEditrice> aggiorna() {
        return casaEditriceRepository.findAll(); 
    }

}
