// необходим для запуска и генерации проекта, прописываем основные базовые настройки
import {bootstrapApplication} from "@angular/platform-browser";
import {AppComponent} from "./app/app.component";
import {provideHttpClient} from "@angular/common/http";
import {provideRouter} from "@angular/router";
import {APP_ROUTES} from "./app/app.routes";

// bootstrapApplication(AppComponent);
bootstrapApplication(AppComponent, {  // типо как в Спринге в Мейн классе, которая запускает апликушку
  providers: [
    provideHttpClient(),
    provideRouter(APP_ROUTES)
  ]
});
