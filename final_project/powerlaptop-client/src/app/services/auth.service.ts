import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { AuthData } from "../models/auth.data";
import { appSettings } from "../app.const";
import {SessionService} from "./session.service";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private _http: HttpClient, private _sessionService: SessionService) { }

  login(username: string, password: string): Observable<any> {
    return this.process(username, password, appSettings.apiOpen + '/auth/register');
  }

  register(username: string, password: string): Observable<any> {
    return this.process(username, password, appSettings.apiOpen + '/auth/authenticate');
  }

  isLoggedIn(): Observable<boolean> {
    return this._sessionService.fromStorage("token")
      .pipe(
        map(token => {
          return !!token;
        })
      );
  }

  private process(username: string, password: string, url: string): Observable<any> {
    const register = {
      username: username,
      password: password,
      roleType: 'PERSONAL'
    };
    return this._http.post(url, register)
      .pipe(
        map(res => {
          return  res as AuthData;
        })
      );
  }
}
