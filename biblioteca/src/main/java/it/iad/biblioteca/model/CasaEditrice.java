package it.iad.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CasaEditrice {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;
    
    @JsonIgnore
    @OneToOne(mappedBy="casaEditrice", cascade = CascadeType.REMOVE)
    private Libro libro;

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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
