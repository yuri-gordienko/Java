import {Component, OnInit} from '@angular/core';
import {PlpService} from "../../services/plp.service";
import {ProductPlpModel} from "../../models/product-plp.model";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Component({  // декоратор,  это и есть plp компонент
  selector: 'app-plp',  // по селекторам вставляем компоненты внутрь других компонентов
  standalone: true,   // чтоб компонент заработал
  templateUrl: './plp.component.html',
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./plp.component.scss']
})
export class PlpComponent implements OnInit { // export аналог public - можно использовать где угодно

  plpList$: Observable<ProductPlpModel[]> = this._plpService.loadProducts() as Observable<ProductPlpModel[]>;

  constructor(private _plpService: PlpService, private _router: Router) { } // инициализация

  ngOnInit(): void { } // говорит, когда инфо вернулась

  redirectToPdp(productId: number): void {   // переадресовываем c Plp на Pdp по id при клике на картинку продукта
    this._router.navigateByUrl('/pdp/' + productId); // сюда прилетаем
  }
}
