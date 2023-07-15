  import {Routes} from "@angular/router"; // импортируем сюда все виды Роутов, которые могут быть
  import {PlpComponent} from "./pages/plp/plp.component";

  // это базовый файл (парент класс) для подключения всех ROUTES в проекте
  export const APP_ROUTES: Routes = [
    {
      path: '',  // кореневой Роут (localhost: 4200) - начальная страница редиректит на 'plp
      redirectTo: 'plp', // попадаем сюда (компонент)
      pathMatch: 'full'  // не строим относительные рауты, строим полный раут
      // подхватывает все компоненты что после full, full смотрит от корня (корень это окончание доменого имени)
    },

    // тут прописываем корневые страницы, корневые url
    {
      path: 'plp', // 1й раут, после слеша перебрасывает сюда
      pathMatch: 'prefix', // когда будем прописывать роуты, путь будет начинаться от корня внутри каталога,
                           //т.е. перед ним уже будет стоять prefix  plp/
                           // после prefix уже переход идет по конкретным id конкретной страницы
                           //pathMatch: 'prefix' это относительный путь, отслеживает все то, что после plp
       // children: [
          //   {
          //     path: '',
          //     component: PlpComponent
          //   },
          //   {
          //     path: '/bla',  // добавляем новые компоненты внутри компонента plp
          //     component: PlpComponentBla
          //   },
          //   {
          //     path: '/ble',
          //     component: PlpComponentBle
          //   }
          // ]
      loadChildren:() => import('./pages/plp/plp.routes').then(m => m.PLP_ROUTES) // PLP_ROUTES отвечает за path: 'plp'
                                                                    // PLP_ROUTES это саб домены
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
      },
        {
          path: 'login',
          pathMatch: 'prefix',
          loadChildren:() => import('./pages/login/login.router').then(m => m.LOGIN_ROUTES)
        },
        {
          path: 'cart',
          pathMatch: 'prefix',
          loadChildren:() => import('./pages/cart/cart.router').then(m => m.CART_ROUTES)
        }
    ];
