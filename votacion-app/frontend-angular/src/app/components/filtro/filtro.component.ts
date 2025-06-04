import { Component, OnInit } from '@angular/core';
import { FiltroService } from '../../services/filtro.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-filtro',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './filtro.component.html'
})
export class FiltroComponent implements OnInit {
  tipo = 'partido';
  nombre = '';
  resultados: any[] = [];

  constructor(private filtroService: FiltroService) {}

  ngOnInit(): void {
    this.cargarInicial();
  }

  buscar() {
    this.filtroService.buscar(this.tipo, this.nombre).subscribe((data: any) => {
      this.resultados = data;
    });
  }

  cargarInicial() {
    this.filtroService.buscar('partido', '').subscribe((data: any) => {
      this.resultados = [...data];
    });

    this.filtroService.buscar('candidato', '').subscribe((data: any) => {
      this.resultados = [...this.resultados, ...data];
    });
  }
}
