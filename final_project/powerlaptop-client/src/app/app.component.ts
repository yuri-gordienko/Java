import { Component } from '@angular/core';
import { RouterOutlet } from "@angular/router";
import { FooterComponent } from "./layout/footer/footer.component";
import {HeaderComponent} from "./layout/header/header.component";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    RouterOutlet,
    FooterComponent,
    HeaderComponent
  ],
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'powerlaptop-client';
}
