package it.iad.biblioteca.serviceimpl;

import it.iad.biblioteca.model.PosizioneScaffale;
import it.iad.biblioteca.repository.PosizioneScaffaleRepository;
import it.iad.biblioteca.service.PosizioneScaffaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosizioneScaffaleServiceImpl implements PosizioneScaffaleService{

    @Autowired
    PosizioneScaffaleRepository posizioneScaffaleRepository;
    
    @Override
    public List<PosizioneScaffale> ricerca(String s) {
        return posizioneScaffaleRepository.findByCodiceContains(s);
    }

    @Override
    public List<PosizioneScaffale> aggiungi(PosizioneScaffale ps) {
        posizioneScaffaleRepository.save(ps);
        return aggiorna();
    }

    @Override
    public List<PosizioneScaffale> modifica(PosizioneScaffale ps) {
        posizioneScaffaleRepository.save(ps);
        return aggiorna();
    }

    @Override
    public List<PosizioneScaffale> rimuovi(PosizioneScaffale ps) {
        posizioneScaffaleRepository.delete(ps);
        return aggiorna();
    }

    @Override
    public List<PosizioneScaffale> aggiorna() {
        return posizioneScaffaleRepository.findAll(); 
    }
}
