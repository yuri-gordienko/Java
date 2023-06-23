import { Component } from '@angular/core';
import {CartService} from "../../services/cart.service";
import {Observable} from "rxjs";
import {AsyncPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-cart',
  standalone: true,
  templateUrl: './cart.component.html',
  imports: [
    NgIf,
    AsyncPipe
  ],
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {

  cart$: Observable<string> = this._cartService.loadCart();

  constructor(private _cartService: CartService) {  // инжектит в конструктор картсервис
  }
}
