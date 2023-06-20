import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PdpService} from "../../services/pdp.service";
import {ProductPdpModel} from "../../models/product-pdp.model";
import {CommonModule} from "@angular/common";
import {BehaviorSubject, Observable, take, tap} from "rxjs";
import {defaultProductResultModel, ProductResultModel} from "../../models/product-result.model";

@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.scss'],
  imports: [
    CommonModule  // для отрисовки картинок в pdp.component.html
  ]
})
export class PdpComponent implements OnInit {

// _нижнее подчеркивание означает что это внутренняя переменная
// класс Observable (отсроченное изменение) позволяет вернуть постоянно подтягивающее последнее изменение нашего объекта
// класс BehaviorSubject хранит последнее состояние, его метод asObservable возвращает ожидаемое состояние (состояние во время ожидания, отложенное состояние)
// подписываемся на состояние "subscribe", сигнализирует когда и какое состояние вернуть
// readonly только для чтения
  private _productResultSub$: BehaviorSubject<ProductResultModel> = new BehaviorSubject<ProductResultModel>(defaultProductResultModel);
  private _isValidProductResultSub$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public readonly productResult$: Observable<ProductResultModel> = this._productResultSub$.asObservable();
  public readonly isValidProductResult$: Observable<boolean> = this._isValidProductResultSub$.asObservable();

  product?: ProductPdpModel;   // ? это Опшинал в Ангуларе

  constructor(private _router: Router, private _pdpService: PdpService) { }

  ngOnInit(): void {
    let url = this._router.routerState.snapshot.url;  // распарсили url
    let productId = url.split('/')[2];   // Сплитом убираем то что до последнего значения
    this._pdpService
      .loadProductById(productId)   // загружаем продукт по id
      .subscribe(value => {   // подписываемся
        this.product = value as ProductPdpModel;  // вытягиваем мапу (филды и значения) из product-pdp.model.ts
      });
  }

  setOs(os: string): void { // создали функцию для присвоенной кнопки, которая принимает Os строку
    this.productResult$
      .pipe(
        take(1),    // берем состояние только один раз
        tap(res => {  // хотим его изменять
          const ps: ProductResultModel = { ...res };  // клонируем переменную ps в последнее состояние ProductResultModel
          ps.os = os;
          this._productResultSub$.next({ ...ps });  // next меняет состояние
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setCpu(cpu: string): void {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.cpu = cpu;
          this._productResultSub$.next({ ...ps });
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setRam(ram: number) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.ram = ram;
          this._productResultSub$.next({ ...ps });
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setSsd(ssd: number) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.ssd = ssd;
          this._productResultSub$.next({ ...ps });
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setColor(color: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.color = color;
          this._productResultSub$.next({ ...ps });
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setDisplayResolution(displayResolution: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.displayResolution = displayResolution;
          this._productResultSub$.next({ ...ps });
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setDisplayType(displayType: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.displayType = displayType;
          this._productResultSub$.next({ ...ps });
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  setDisplaySize(displaySize: string) {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.displaySize = displaySize;
          this._productResultSub$.next({ ...ps });
          this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  checkForUndefined(ps: any): void {  // функция проверяет все критерии продукта выбраны в финальном варианте
    for (let key in ps) {
      if (ps[key] !== undefined) {   // если все поля выбраны (не null)
        this._isValidProductResultSub$.next(true);
      } else {
        this._isValidProductResultSub$.next(false);
      }
    }
  }
}
