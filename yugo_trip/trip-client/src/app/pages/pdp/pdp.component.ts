import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
// import {NavigationEnd, Router, RouterEvent} from "@angular/router";
import { CommonModule } from "@angular/common";
// import { FormBuilder, FormControl, Validators } from "@angular/forms";
import { BehaviorSubject, filter, Observable, switchMap, take, tap } from "rxjs";

import { PdpService } from "../../services/pdp.service";
// import { CartService } from "../../services/cart.service";
import { TourPdpModel } from "../../models/tour-pdp.model";
// import { defaultProductResultModel, ProductResultModel } from "../../models/product-result.model";

@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.scss'],
  imports: [CommonModule]
})
export class PdpComponent implements OnInit {

//   private _productResultSub$: BehaviorSubject<ProductResultModel> = new BehaviorSubject<ProductResultModel>(defaultProductResultModel);
//   // private _isValidProductResultSub$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
//   public readonly productResult$: Observable<ProductResultModel> = this._productResultSub$.asObservable();
//   // public readonly isValidProductResult$: Observable<boolean> = this._isValidProductResultSub$.asObservable();

  tour?: TourPdpModel;

  constructor(
//   private _cartService: CartService,
//   private _fb: FormBuilder,
  private _router: Router,
  private _pdpService: PdpService) { }

//   ngOnInit(): void {
//     this._router.events.pipe(
//       filter((e): e is RouterEvent => e instanceof RouterEvent),
//       take(1)
//     ).subscribe((e: RouterEvent) => {
//       this._loadTour();
//     });
//     this._loadTour();
//     this._form.statusChanges.subscribe(status => console.log('status', status))
//   }
//
//   private _loadTour(): void {
//     let url : string = this._router.routerState.snapshot.url;
//     let tourId = url.split('/')[2];
//     console.log('url', url)
//     console.log('tourId', tourId)
//     this._pdpService
//       .loadTourById(tourId)
//       .subscribe(value => {
//         this.tour = value as TourPdpModel;
//       });
//   }


 ngOnInit(): void {
    let url : string = this._router.routerState.snapshot.url;
    let tourId : string = url.split('/')[2];
    this._pdpService
      .loadTourById(tourId)
      .subscribe(value => {
        let tour: TourPdpModel = value as TourPdpModel;
        console.log('tour', tour);
        this.tour = tour;
      });
  }
}
