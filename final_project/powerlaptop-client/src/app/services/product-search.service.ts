import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { DataContainer } from "../models/data.container";
import { appSettings } from "../app.const";

@Injectable({
  providedIn: 'root'
})
export class ProductSearchService {

  constructor(private _http: HttpClient) { }

  searchProduct(query: string): Observable<any> {
    return this._http.get(appSettings.apiOpen + '/products/search?query=' + query)
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
