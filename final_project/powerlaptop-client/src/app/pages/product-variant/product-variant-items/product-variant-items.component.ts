import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Observable} from "rxjs";
import {FormBuilder, FormControl, ReactiveFormsModule} from "@angular/forms";

import {ProductVariantService} from "../../../services/product-variant.service";
import {DataTableModel} from "../../../models/data-table.model";
import {ProductVariantModel} from "../../../models/product-variant.model";

@Component({
  selector: 'app-product-variant-items',
  templateUrl: './product-variant-items.component.html',
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  standalone: true
})
export class ProductVariantItemsComponent implements OnInit {

  data$: Observable<DataTableModel<ProductVariantModel>> | undefined;
  sizes: number[] = [5,10,25,50,100];
  sizeForm = this._fb.group({
    size: new FormControl(10)
  })

  constructor(private _productVariantService: ProductVariantService, private _fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.data$ = this._productVariantService.loadProductVariants();
    this.sizeForm.valueChanges.subscribe(valueChanges => {
      if (valueChanges.size) {
        this.data$ = this._productVariantService.loadProductVariants(0, valueChanges.size);
      }
    })
  }

  showPage(page: number): void {
    this.data$ = this._productVariantService.loadProductVariants(page);
  }
}
