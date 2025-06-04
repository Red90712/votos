import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Vereda {
  nombre: string;
  totalVotantes: number;
}

@Injectable({
  providedIn: 'root'
})
export class VeredasService {
  private apiUrl = 'http://localhost:8080/backend-java/api/veredas'; // ajusta más adelante

  constructor(private http: HttpClient) {}

  getVeredas(): Observable<Vereda[]> {
    return this.http.get<Vereda[]>(this.apiUrl);
  }
}
