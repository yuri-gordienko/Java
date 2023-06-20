import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataContainer} from "../models/data.container";

@Injectable({
  providedIn: 'root'
})
export class PlpService {

  constructor(private _http: HttpClient) {    // с помощью него ходим на бэкенд
  }

  loadProducts(): Observable<Object> {
    return this._http.get('http://localhost:8080/products/plp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
