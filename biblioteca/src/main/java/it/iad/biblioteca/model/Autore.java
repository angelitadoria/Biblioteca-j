package it.iad.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autore {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String nome;
    
    @Column
    private String cognome;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "autori")
    private List<Libro> libri;
    
    public Autore() {
    }

    public Autore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
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
