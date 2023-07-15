import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { DataContainer } from "../models/data.container";
import { appSettings } from "../app.const";

@Injectable({
  providedIn: 'root'
})
export class TourSearchService {

  constructor(private _http: HttpClient) { }

  searchTour(query: string): Observable<any> {
    return this._http.get('http://localhost:8080/api/tours/search?query=' + query)
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
