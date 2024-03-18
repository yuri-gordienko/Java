import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {map, Observable} from "rxjs";

import {DataTableModel} from "../models/data-table.model";
import {ProductVariantModel} from "../models/product-variant.model";
import {DataContainer} from "../models/data.container";
import {appSettings} from "../app.const";

@Injectable({
  providedIn: 'root'
})
export class ProductVariantService {

  constructor(private _http: HttpClient) {
  }

  loadProductVariants(page: number = 0, size: number = 10, sort: string = 'desc', order: string = 'id')
    : Observable<DataTableModel<ProductVariantModel>> {
    const params: HttpParams = new HttpParams()
      .set('page', page)
      .set('size', size)
      .set('sort', sort)
      .set('order', order);
    return this._http.get(appSettings.apiPrivateAdmin + '/product-variants', {params})
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }

  createProduct(product: ProductVariantModel): Observable<boolean> {
    return this._http.post(appSettings.apiPrivateAdmin + '/product-variants', product)
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
