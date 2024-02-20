import { Component } from '@angular/core';
import {CartService} from "../../services/cart.service";
import {Observable} from "rxjs";
import {AsyncPipe, DatePipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {CartModel} from "../../models/cart.model";

@Component({
  selector: 'app-cart',
  standalone: true,
  templateUrl: './cart.component.html',
  imports: [
    NgIf,
    AsyncPipe,
    JsonPipe,
    NgForOf,
    DatePipe
  ],
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {

  cart$: Observable<CartModel> = this._cartService.loadCart();

  constructor(private _cartService: CartService) {
  }
}
