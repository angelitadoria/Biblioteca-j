import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CriterioRicercaDto } from 'src/dto/criterio-ricerca-dto';
import { ListaLibroDto } from 'src/dto/lista-libro-dto';
import { Libro } from '../entità/libro';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  libro: Libro;
  listaLibri: Libro[];
  criterio: string;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  aggiorna() {
    let oss: Observable<ListaLibroDto> = this.http.get<ListaLibroDto>('http://localhost:8080/aggiorna');
    oss.subscribe(r => this.listaLibri = r.listaLibri);
  }

  cercaByCodice() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    let oss: Observable<ListaLibroDto> = this.http.post<ListaLibroDto>('http://localhost:8080/cerca-codice', dto);
    oss.subscribe(r => this.listaLibri = r.listaLibri);
  }

  cercaJpql() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    let oss: Observable<ListaLibroDto> = this.http.post<ListaLibroDto>('http://localhost:8080/cerca-jpql', dto);
    oss.subscribe(r => this.listaLibri = r.listaLibri);
  }

  cercaJpa() {
    let dto: CriterioRicercaDto = new CriterioRicercaDto();
    dto.criterio = this.criterio;
    let oss: Observable<ListaLibroDto> = this.http.post<ListaLibroDto>('http://localhost:8080/cerca-jpa', dto);
    oss.subscribe(r => this.listaLibri = r.listaLibri);
  }
}
