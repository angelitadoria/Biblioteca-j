package it.iad.biblioteca.controller;

import it.iad.biblioteca.dto.CriterioRicercaDto;
import it.iad.biblioteca.dto.ListaLibroDto;
import it.iad.biblioteca.dto.RicercaLibroDto;
import it.iad.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class BibliotecaController {
    @Autowired
    LibroService libroService;
    
    @RequestMapping("/cerca-codice")
    @ResponseBody
    public ListaLibroDto ricercaPerCodice(@RequestBody CriterioRicercaDto dto){
        return new ListaLibroDto(libroService.ricercaPerCodice(dto.getCriterio()));
    }
    
    @RequestMapping("/cerca-jpql")
    @ResponseBody
    public ListaLibroDto ricercaJpql(@RequestBody RicercaLibroDto dto){
        return new ListaLibroDto(libroService.ricercaJpql
        (dto.getCriterio(), dto.getCognome(), dto.getCasaEditrice()));
    }
    
    @RequestMapping("/cerca-jpa")
    @ResponseBody
    public ListaLibroDto ricercaJpa(@RequestBody RicercaLibroDto dto){
        return new ListaLibroDto(libroService.ricercaJpa
        (dto.getCriterio(), dto.getCognome(), dto.getCasaEditrice()));
    }
}
