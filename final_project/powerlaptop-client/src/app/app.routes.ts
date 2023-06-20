  import {Routes} from "@angular/router";
  import {PlpComponent} from "./pages/plp/plp.component";

  // это базовый файл (парент класс) для подключения всех ROUTES в проекте
  export const APP_ROUTES: Routes = [
    {
      path: '',  // кореневой Роут (localhost: 4200) - начальная страница редиректит на 'plp
      redirectTo: 'plp', // попадаем сюда (компонент)
      pathMatch: 'full'  // не строим относительные рауты, строим полный раут
    },
    {
      path: 'plp', // 1й раут, после слеша перебрасывает сюда
      pathMatch: 'prefix', // когда будем прописывать роуты, путь будет начинаться от корня внутри каталога,
                           //т.е. перед ним уже будет стоять prefix  plp/
       // children: [
          //   {
          //     path: '',
          //     component: PlpComponent
          //   },
          //   {
          //     path: '/bla',
          //     component: PlpComponentBla
          //   },
          //   {
          //     path: '/ble',
          //     component: PlpComponentBle
          //   }
          // ]
      loadChildren:() => import('./pages/plp/plp.routes').then(m => m.PLP_ROUTES) // PLP_ROUTES отвечает за path: 'plp'
    },
    {
        path: 'pdp',
        pathMatch: 'prefix',
        loadChildren:() => import('./pages/pdp/pdp.routes').then(m => m.PDP_ROUTES)
      },
      {
        path: 'register',
        pathMatch: 'prefix',
        loadChildren:() => import('./pages/register/register.router').then(m => m.REGISTER_ROUTES)
      }
    ];
