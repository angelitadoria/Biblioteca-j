package it.iad.biblioteca.dto;

public class CriterioRicercaDto {
    
    private String criterio;

    public CriterioRicercaDto() {
    }

    public CriterioRicercaDto(String criterio) {
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
    
}
