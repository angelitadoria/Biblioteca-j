package it.iad.biblioteca.service;

import it.iad.biblioteca.model.PosizioneScaffale;
import java.util.List;

public interface PosizioneScaffaleService {

    List<PosizioneScaffale> ricerca(String s);
    List<PosizioneScaffale> aggiungi(PosizioneScaffale ps);
    List<PosizioneScaffale> modifica(PosizioneScaffale ps);
    List<PosizioneScaffale> rimuovi(PosizioneScaffale ps);
    List<PosizioneScaffale> aggiorna();
}
