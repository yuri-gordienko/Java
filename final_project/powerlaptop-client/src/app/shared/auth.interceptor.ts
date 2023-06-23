import { HttpInterceptorFn } from "@angular/common/http";
import { tap } from "rxjs";
import { appSettings } from "../app.const";

export const authInterceptor: HttpInterceptorFn = (req, next) => {  // перехватчик, хотим модернизировать запрос

    if (req.url.startsWith(appSettings.apiPrivate)) { // если запрос начинается с apiPrivate
      const token = localStorage.getItem('token');  // то берем из локалстореджа токен
      console.log(token);
      if (token) {
        const accessToken = JSON.parse(token).access_token; // из строки делаем объект
        const headers = req.headers.set('Authorization', 'Bearer ' + accessToken);  // и вставляем в Бирер
        req = req.clone({headers});
      }
    }

    return next(req).pipe(
        tap(resp => console.log('response', resp))
    );
}
