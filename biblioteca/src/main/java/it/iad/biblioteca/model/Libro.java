package it.iad.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.data.annotation.Reference;

@Entity
public class Libro {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titolo;

    @Column
    private int anno;

    @Column
    private String genere;

    @Column
    private String codice;

    @JsonIgnoreProperties(value = "libro", allowGetters = true, allowSetters = true)
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(referencedColumnName = "id")
    private List<Autore> autori;

    @JsonIgnoreProperties(value = "libro", allowGetters = true, allowSetters = true)
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(referencedColumnName = "id")
    private CasaEditrice casaEditrice;
    
    @JsonIgnoreProperties(value = "libro", allowGetters = true, allowSetters = true)
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private PosizioneScaffale posizioneScaffale;
    
    public Libro() {
    }

    public Libro(String titolo, int anno, String genere, String codice) {
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
        this.codice = codice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public List<Autore> getAutori() {
        if (autori == null) {
            autori = new ArrayList<>();
        }
        return autori;
    }

    public void setAutori(List<Autore> autori) {
        this.autori = autori;
    }

    public CasaEditrice getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(CasaEditrice casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    public PosizioneScaffale getPosizioneScaffale() {
        return posizioneScaffale;
    }

    public void setPosizioneScaffale(PosizioneScaffale posizioneScaffale) {
        this.posizioneScaffale = posizioneScaffale;
    }

}
