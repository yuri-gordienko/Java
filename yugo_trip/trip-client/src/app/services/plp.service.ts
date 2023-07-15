import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { DataContainer } from "../models/data.container";
import { appSettings } from "../app.const";

@Injectable({
  providedIn: 'root'
})
export class PlpService {

  constructor(private _http: HttpClient) { }

  loadTours(): Observable<Object> {
    return this._http.get(appSettings.apiOpen + '/tours/plp')
          .pipe(
            map(res => {
              const data: DataContainer = res as DataContainer;
              return data.data;
            })
          );
      }
}
