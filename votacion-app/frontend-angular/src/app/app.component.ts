import { Component } from '@angular/core';
import { FiltroComponent } from './components/filtro/filtro.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FiltroComponent, RouterOutlet],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'Sistema de Votación';
}
