import {Routes} from "@angular/router";
import {PlpComponent} from "./plp.component";

export const PLP_ROUTES: Routes = [
  {
    path: '', // корень
    component: PlpComponent   // PlpComponent отвечает, отлавливает PLP_ROUTES
  }
]
