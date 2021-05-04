package it.iad.biblioteca.controller;

import it.iad.biblioteca.service.DatiTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class DatiTestController {

    @Autowired
    DatiTestService datiTestService;
    
    @RequestMapping("/genera-dati-test")
    public void generaDatiTest() {
        datiTestService.generaDatiTest();
    }
}
