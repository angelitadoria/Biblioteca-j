package it.iad.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PosizioneScaffale {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;
    
    @Column
    private int giacenza;
    
    @JsonIgnore
    @OneToMany(mappedBy = "posizioneScaffale", cascade = CascadeType.REMOVE)
    private List<Libro> libri;

    public PosizioneScaffale() {
    }

    public PosizioneScaffale(String codice, int giacenza) {
        this.codice = codice;
        this.giacenza = giacenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    public List<Libro> getLibri() {
        if(libri == null){
            libri = new ArrayList<>();
        }
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }
    
    
}
