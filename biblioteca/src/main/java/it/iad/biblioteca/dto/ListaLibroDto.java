package it.iad.biblioteca.dto;

import it.iad.biblioteca.model.Libro;
import java.util.ArrayList;
import java.util.List;

public class ListaLibroDto {
    private List<Libro> listaLibri;

    public ListaLibroDto() {
    }

    public ListaLibroDto(List<Libro> listaLibri) {
        this.listaLibri = listaLibri;
    }

    public List<Libro> getListaLibri() {
        if(listaLibri == null){
            listaLibri = new ArrayList<>();
        }
        return listaLibri;
    }

    public void setListaLibri(List<Libro> listaLibri) {
        this.listaLibri = listaLibri;
    }
    
    
    
}
