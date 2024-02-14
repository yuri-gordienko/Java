import { Routes } from '@angular/router';
import {PlpComponent} from "./pages/plp/plp.component";

export const APP_ROUTES: Routes = [
{
path: '',
redirectTo: 'plp',
pathMatch: 'full'
},
{
path: 'plp',
pathMatch: 'prefix',
loadChildren:() => import('./pages/plp/plp.routes').then(m => m.PLP_ROUTES)
}
];
