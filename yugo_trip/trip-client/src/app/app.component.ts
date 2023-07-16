import { Component } from '@angular/core';
import { FooterComponent } from "./layout/footer/footer.component";
// import {HeaderComponent} from "./layout/header/header.componentt";
import { RouterOutlet } from "@angular/router";


@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    FooterComponent,
//     HeaderComponent,
    RouterOutlet
  ],
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'trip-client';
}
