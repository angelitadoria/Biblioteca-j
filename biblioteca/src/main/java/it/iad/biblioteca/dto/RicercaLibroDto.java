package it.iad.biblioteca.dto;

public class RicercaLibroDto extends CriterioRicercaDto{
    private String cognome;
    private String casaEditrice;

    public RicercaLibroDto() {
    }

    public RicercaLibroDto(String cognome, String casaEditrice, String criterio) {
        super(criterio);
        this.cognome = cognome;
        this.casaEditrice = casaEditrice;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(String casaEditrice) {
        this.casaEditrice = casaEditrice;
    }
    
    
}
