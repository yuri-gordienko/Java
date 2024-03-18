import {Component, OnInit} from '@angular/core';
import {ProductVariantService} from "../../../services/product-variant.service";
import {FormBuilder, FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgForOf} from "@angular/common";
import {ProductVariantModel} from "../../../models/product-variant.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-variant-add',
  templateUrl: './product-variant-add.component.html',
  styleUrls: ['./product-variant-add.component.scss'],
  imports: [
    ReactiveFormsModule,
    NgForOf
  ],
  standalone: true
})
export class ProductVariantAddComponent implements OnInit {

  osTypes: string[] = [
    'WINDOWS_10_PRO',
    'WINDOWS_11_PRO',
    'WINDOWS_11_HOME',
    'LINUX_UBUNTU',
    'LINUX_FEDORA',
    'LINUX_RED_HAT',
    'MAC_OS'
  ];

  cpuTypes: string[] = [
    'AMD Ryzen 9 7945HX',
    'Intel Core i9-13980HX',
    'Intel Core i9-13950HX',
    'Intel Core i9-13900HX',
    'Intel Core i9-12950HX',
    'Intel Core i9-12900HX',
    'Intel Core i7-13850HX',
    'Intel Core i7-13700HX',
    'AMD Ryzen 9 7845HX',
    'Intel Core i7-12850HX',
    'Apple M2 Max',
    'Apple M2 Pro',
  ];

  ramTypes: number[] = [16, 32, 64, 96, 128]
  ssdTypes: number[] = [512, 1024, 2048, 4096, 8192]
  colorTypes: string[] = [
    'Black',
    'Grey',
    'Silver',
    'White'
  ];
  displayResolutionTypes: string[] = [
    '1920X1080',
    '1920X1200',
    '2560X1600',
    '3840X2160',
  ]

  displayTypes: string[] = ['IPS', 'OLED', 'XDR']
  displaySizes: string[] = ['15,6', '16', '17']

  formProduct = this._fb.group({
    os: new FormControl('', [Validators.required]),
    cpu: new FormControl('', [Validators.required]),
    ram: new FormControl(0, [Validators.required]),
    ssd: new FormControl(0, [Validators.required]),
    color: new FormControl('', [Validators.required]),
    displayResolution: new FormControl('', [Validators.required]),
    displayType: new FormControl('', [Validators.required]),
    displaySize: new FormControl('', [Validators.required])
  })

  constructor(
    private _productVariantService: ProductVariantService,
    private _fb: FormBuilder,
    private _router: Router) {
  }

  ngOnInit(): void {
    this.formProduct.valueChanges.subscribe(values => {
      console.log('values', values)
    })
  }

  create(): void {

    let some = 'ffg,gssg,sgsg';
    let s = some.split(',');



    if (this.formProduct.valid) {
      console.log(this.formProduct.value)

      let os = this.formProduct.value.os as string;
      let cpu = this.formProduct.value.cpu as string;
      let ram = this.formProduct.value.ram as number;
      let ssd = this.formProduct.value.ssd as number;
      let color = this.formProduct.value.color as string;
      let displayResolution = this.formProduct.value.displayResolution as string;
      let displayType = this.formProduct.value.displayType as string;
      let displaySize = this.formProduct.value.displaySize as string;

      let product: ProductVariantModel = {
        os,
        cpu,
        ram,
        ssd,
        color,
        displayResolution,
        displayType,
        displaySize
      };

      this._productVariantService.createProduct(product)
        .subscribe(
          (res) => {
            if (res) {
              this._router.navigateByUrl('product-variant')
            }
          },
          (error) => {
            console.log('error', error)
          }
        );
    }
  }
}
