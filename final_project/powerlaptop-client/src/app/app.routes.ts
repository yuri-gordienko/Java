import { Routes } from "@angular/router";

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
  },
  {
    path: 'pdp',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/pdp/pdp.routes').then(m => m.PDP_ROUTES)
  },
  {
    path: 'register',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/register/register.router').then(m => m.REGISTER_ROUTES)
  },
  {
    path: 'login',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/login/login.router').then(m => m.LOGIN_ROUTES)
  },
  {
    path: 'cart',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/cart/cart.router').then(m => m.CART_ROUTES)
  },
  {
    path: 'product-variant',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/product-variant/product-variant.route').then(m => m.PRODUCT_VARIANT_ROUTES)
  }
];
