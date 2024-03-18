import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router, RouterEvent} from "@angular/router";
import { CommonModule } from "@angular/common";
import { FormBuilder, FormControl, Validators } from "@angular/forms";
import { BehaviorSubject, filter, Observable, switchMap, take, tap } from "rxjs";

import { PdpService } from "../../services/pdp.service";
import { CartService } from "../../services/cart.service";
import { ProductPdpModel } from "../../models/product-pdp.model";
import { defaultProductResultModel, ProductResultModel } from "../../models/product-result.model";

@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.scss'],
  imports: [
    CommonModule
  ]
})
export class PdpComponent implements OnInit {

  private _productResultSub$: BehaviorSubject<ProductResultModel> = new BehaviorSubject<ProductResultModel>(defaultProductResultModel);
  // private _isValidProductResultSub$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public readonly productResult$: Observable<ProductResultModel> = this._productResultSub$.asObservable();
  // public readonly isValidProductResult$: Observable<boolean> = this._isValidProductResultSub$.asObservable();

  product?: ProductPdpModel;

  _form = this._fb.group({
    os: new FormControl('', [Validators.required]),
    cpu: new FormControl('', [Validators.required]),
    ram: new FormControl(0, [Validators.required]),
    ssd: new FormControl(0, [Validators.required]),
    color: new FormControl('', [Validators.required]),
    displayResolution: new FormControl('', [Validators.required]),
    displayType: new FormControl('', [Validators.required]),
    displaySize: new FormControl('', [Validators.required]),
  })

  constructor(private _fb: FormBuilder, private _router: Router, private _pdpService: PdpService, private _cartService: CartService) { }

  ngOnInit(): void {
    this._router.events.pipe(
      filter((e): e is RouterEvent => e instanceof RouterEvent),
      take(1)
    ).subscribe((e: RouterEvent) => {
      this._loadProduct();
    });
    this._loadProduct();
    this._form.statusChanges.subscribe(status => console.log('status', status))
  }

  private _loadProduct(): void {
    let url = this._router.routerState.snapshot.url;
    let productId = url.split('/')[2];
    console.log('url', url)
    console.log('productId', productId)
    this._pdpService
      .loadProductById(productId)
      .subscribe(value => {
        this.product = value as ProductPdpModel;
      });
  }

  setOs(os: string): void {
    this.productResult$
      .pipe(
        take(1),
        tap(res => {
          const ps: ProductResultModel = { ...res };
          ps.os = os;
          this._productResultSub$.next({ ...ps });
          this._form.controls.os.setValue(os);
          // this.checkForUndefined(ps);
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
          this._form.controls.cpu.setValue(cpu);
          // this.checkForUndefined(ps);
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
          this._form.controls.ram.setValue(ram);
          // this.checkForUndefined(ps);
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
          this._form.controls.ssd.setValue(ssd);
          // this.checkForUndefined(ps);
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
          this._form.controls.color.setValue(color);
          // this.checkForUndefined(ps);
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
          this._form.controls.displayResolution.setValue(displayResolution);
          // this.checkForUndefined(ps);
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
          this._form.controls.displayType.setValue(displayType);
          // this.checkForUndefined(ps);
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
          this._form.controls.displaySize.setValue(displaySize);
          // this.checkForUndefined(ps);
        })
      )
      .subscribe();
  }

  // checkForUndefined(ps: any): void {
  //   for (let key in ps) {
  //     if (ps[key] !== undefined) {
  //       this._isValidProductResultSub$.next(true);
  //     } else {
  //       this._isValidProductResultSub$.next(false);
  //     }
  //   }
  // }

  addToCart(): void {
    this.productResult$
      .pipe(
        switchMap(res => this._pdpService.loadProductIdByVariants(this.product?.id as number, res)),
        switchMap(res => this._cartService.addToCart(res, 1)),
      )
      .subscribe((res) => {
        this._router.navigateByUrl('/cart')
      }, (error) => {
        console.log('error', error);
        this._router.navigateByUrl('/login')
      });
  }
}
