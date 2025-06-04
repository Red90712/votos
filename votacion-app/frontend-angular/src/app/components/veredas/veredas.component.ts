import { Component, OnInit } from '@angular/core';
import { VeredasService, Vereda } from '../../services/veredas.service';

@Component({
  selector: 'app-veredas',
  templateUrl: './veredas.component.html',
  styleUrls: ['./veredas.component.scss']
})
export class VeredasComponent implements OnInit {
  veredas: Vereda[] = [];

  constructor(private veredaService: VeredasService) {}

  ngOnInit(): void {
    // Datos simulados por ahora
    this.veredas = [
      { nombre: 'Vereda La Loma', totalVotantes: 120 },
      { nombre: 'Vereda El Encanto', totalVotantes: 95 }
    ];
  }
  
}
