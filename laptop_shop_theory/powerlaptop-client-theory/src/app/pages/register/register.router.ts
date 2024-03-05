// необходим для перехода по компонентам

import {Routes} from "@angular/router";
import {RegisterComponent} from "./register.component";

export const REGISTER_ROUTES: Routes = [
  {
    path: '',
    component: RegisterComponent
  }
];
