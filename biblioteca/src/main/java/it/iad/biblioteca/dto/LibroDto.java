package it.iad.biblioteca.dto;

import it.iad.biblioteca.model.Libro;

public class LibroDto {

    private Libro libro;

    public LibroDto() {
    }

    public LibroDto(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
