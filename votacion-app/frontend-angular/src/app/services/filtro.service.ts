import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FiltroService {
  private apiUrl = 'http://localhost:8080/ProyectoF/api/filtro';

  constructor(private http: HttpClient) {}

  buscar(tipo: string, nombre: string) {
    return this.http.get(`${this.apiUrl}?tipo=${tipo}&nombre=${nombre}`);
  }
}
