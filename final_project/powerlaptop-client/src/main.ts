// необходим для запуска и генерации проекта, прописываем основные базовые настройки
import { bootstrapApplication } from "@angular/platform-browser";
import { provideHttpClient, withInterceptors } from "@angular/common/http";
import { provideRouter } from "@angular/router";

import { AppComponent } from "./app/app.component";
import { authInterceptor } from "./app/shared/auth.interceptor";
import { APP_ROUTES } from "./app/app.routes";

// bootstrapApplication(AppComponent);
bootstrapApplication(AppComponent, {  // типо как в Спринге в Мейн классе, которая запускает апликушку
  providers: [
    provideHttpClient(
    withInterceptors([authInterceptor]) // вставили перехватчик внутрь провайдера, которые будут работать в HttpClient
        // [authInterceptor] сюда можно дать имя любой функции
        // хотим перехватить реквест и модернизировать его
        ),
    provideRouter(APP_ROUTES)
  ]
});
