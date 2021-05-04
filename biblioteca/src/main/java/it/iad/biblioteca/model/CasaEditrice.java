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
public class CasaEditrice {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy="casaEditrice", cascade = CascadeType.REMOVE)
    private List<Libro> libri;

    public CasaEditrice() {
    }

    public CasaEditrice(String nome) {
        this.nome = nome;
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

    public List<Libro> getLibri() {
        if (libri == null){
            libri = new ArrayList<>();
        }
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

}
