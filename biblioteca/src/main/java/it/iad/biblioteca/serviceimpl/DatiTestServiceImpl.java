package it.iad.biblioteca.serviceimpl;

import it.iad.biblioteca.model.Autore;
import it.iad.biblioteca.model.CasaEditrice;
import it.iad.biblioteca.model.Libro;
import it.iad.biblioteca.model.PosizioneScaffale;
import it.iad.biblioteca.repository.AutoreRepository;
import it.iad.biblioteca.repository.CasaEditriceRepository;
import it.iad.biblioteca.repository.LibroRepository;
import it.iad.biblioteca.repository.PosizioneScaffaleRepository;
import it.iad.biblioteca.service.DatiTestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatiTestServiceImpl implements DatiTestService {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    AutoreRepository autoreRepository;

    @Autowired
    CasaEditriceRepository casaEditriceRepository;

    @Autowired
    PosizioneScaffaleRepository posizioneScaffaleRepository;

    @Override
    public void generaDatiTest() {
        //Cancellazione dati db
        libroRepository.deleteAllInBatch();
        autoreRepository.deleteAllInBatch();
        casaEditriceRepository.deleteAllInBatch();
        posizioneScaffaleRepository.deleteAllInBatch();

        //creo libri, autori, case, posizioni
        Libro libro;
        Autore autore;
        CasaEditrice ce;
        PosizioneScaffale ps;
        for (int i = 0; i < 10; i++) {
            libro = new Libro("titolo" + i, 199 + i, "genere" + i, "codice" + i);
            libroRepository.save(libro);
            autore = new Autore("nome" + i, "cognome" + i);
            autoreRepository.save(autore);
            ce = new CasaEditrice("nome" + i);
            casaEditriceRepository.save(ce);
            ps = new PosizioneScaffale("codice" + i, 5);
            posizioneScaffaleRepository.save(ps);
        }

        //associo libro a casa editrice
        List<Libro> listaLibri = libroRepository.findAll();
        List<CasaEditrice> listaCase = casaEditriceRepository.findAll();
        for (int i = 0; i < listaLibri.size(); i++) {
            listaLibri.get(i).setCasaEditrice(listaCase.get(i));
            libroRepository.save(listaLibri.get(i));
            listaCase.get(i).getLibri().add(listaLibri.get(i));
            casaEditriceRepository.save(listaCase.get(i));
        }

        //associo libro a posizione
        List<PosizioneScaffale> listaPosizioni = posizioneScaffaleRepository.findAll();
        for (int i = 0; i < listaLibri.size(); i++) {
            listaLibri.get(i).setPosizioneScaffale(listaPosizioni.get(i));
            libroRepository.save(listaLibri.get(i));
            listaPosizioni.get(i).getLibri().add(listaLibri.get(i));
            posizioneScaffaleRepository.save(listaPosizioni.get(i));
        }
        
        //associo libro ad autore
        associaLibroAutore();

    }
    
    //metodo per associare libro ad autore
    void associaLibroAutore() {
        //ManyToMany
        List<Libro> listaLibri = libroRepository.findAll().subList(1, 3);
        List<Libro> listaLibri2 = libroRepository.findAll().subList(4, 10);
        List<Autore> listaAutori = autoreRepository.findAll().subList(1, 3);
        List<Autore> listaAutori2 = autoreRepository.findAll().subList(4, 10);
        
        //Associo ad ogni libro di listaLibri la listaAutori
        listaLibri.forEach(p -> {
            List<Autore> autori = p.getAutori();
            listaAutori.forEach(s -> {
                autori.add(s);
            });
            libroRepository.save(p);
        });

        //Associo ad ogni autore della listaAutoru la listaLibri
        listaAutori.forEach(s -> {
            List<Libro> libri = s.getLibri();
            listaLibri.forEach(p -> {
                libri.add(p);
            });
            autoreRepository.save(s);
        });
        
        //Associo libri rimanenti 
         for (int i = 0; i < listaLibri2.size(); i++) {
            listaLibri2.get(i).getAutori().add(listaAutori2.get(i));
            libroRepository.save(listaLibri2.get(i));
            listaAutori2.get(i).getLibri().add(listaLibri2.get(i));
            autoreRepository.save(listaAutori2.get(i));
        }
    }

}
