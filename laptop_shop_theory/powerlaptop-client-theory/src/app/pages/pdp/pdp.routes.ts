import {Routes} from "@angular/router";
import {PdpComponent} from "./pdp.component";

export const PDP_ROUTES: Routes = [
  {
    path: ':id', // корень,  id конкретного продукта
    component: PdpComponent // отвечает за PDP_ROUTES
  }
];
