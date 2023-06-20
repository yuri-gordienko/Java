import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {DataContainer} from "../models/data.container";
import {AuthData} from "../models/auth.data";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private _http: HttpClient ) {
  }

  register(username: string, password: string): Observable<any> { // функция принимает вводимые данные
    const register = {  // передаем бади
      username: username,
      password: password,
      roleType: 'PERSONAL'
    };
    return this._http.post('http://localhost:8080/api/v1/auth/register', register)  // пост запрос, вложили бади регистрации
      .pipe(
        map(res => {
          return  res as AuthData;  // в респонсе получаем данные авторизации
        })
      );
  }
}
