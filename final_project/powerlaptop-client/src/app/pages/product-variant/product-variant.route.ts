import {Routes} from "@angular/router";
import {ProductVariantItemsComponent} from "./product-variant-items/product-variant-items.component";
import {ProductVariantAddComponent} from "./product-variant-add/product-variant-add.component";

export const PRODUCT_VARIANT_ROUTES: Routes = [
  {
    path: '',
    component: ProductVariantItemsComponent
  },
  {
    path: 'new',
    component: ProductVariantAddComponent
  }
];
