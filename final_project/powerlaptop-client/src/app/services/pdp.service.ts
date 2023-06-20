import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataContainer} from "../models/data.container";

@Injectable({
  providedIn: 'root'
})
export class PdpService {

  constructor(private _http: HttpClient) { }

  loadProductById(productId: string): Observable<any> {
    return this._http.get('http://localhost:8080/products/' + productId + '/pdp')
      .pipe(
        map(res => {
          const data: DataContainer = res as DataContainer;
          return data.data;
        })
      );
  }
}
