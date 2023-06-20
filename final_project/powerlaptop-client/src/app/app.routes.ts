  import {Routes} from "@angular/router";
  import {PlpComponent} from "./pages/plp/plp.component";

  // это базовый файл (парент класс) для подключения всех ROUTES в проекте
  export const APP_ROUTES: Routes = [
    {
      path: '',  // кореневой Роут (localhost: 4200) - начальная страница редиректит на 'plp
      redirectTo: 'plp', // попадаем сюда (компонент)
      pathMatch: 'full'  // не строим относительные рауты, строим полный раут
      // подхватывает все компоненты что после full, full смотрит от корня (корень это окончание доменого имени)
    },
    {
      path: 'plp', // 1й раут, после слеша перебрасывает сюда
      pathMatch: 'prefix', // когда будем прописывать роуты, путь будет начинаться от корня внутри каталога,
                           //т.е. перед ним уже будет стоять prefix  plp/
                           // после prefix уже переход идет по конкретным id конкретной страницы
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
        path: 'register', // когда попадаем на этот компонент, то отрабатывает /register.router
        pathMatch: 'prefix',
        // чтоб при запуске системы, попадали на страничку регистрации
        loadChildren:() => import('./pages/register/register.router').then(m => m.REGISTER_ROUTES)
      }
    ];
