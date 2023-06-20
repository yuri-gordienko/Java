import { Component } from '@angular/core';
import {PlpComponent} from "./pages/plp/plp.component";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-root',
  standalone: true, // чтоб заработал компонент
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
//   imports: [PlpComponent],
  imports: [RouterOutlet]

})
export class AppComponent {
  title = 'powerlaptop-client';
}
