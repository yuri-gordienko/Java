import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AsyncPipe, JsonPipe, NgForOf, NgIf } from "@angular/common";
import { Observable } from "rxjs";

import { PlpService } from "../../services/plp.service";
import { TourPlpModel } from "../../models/tour-plp.model";

@Component({
  selector: 'app-plp',
  standalone: true,
  templateUrl: './plp.component.html',
  imports: [
    JsonPipe,
    AsyncPipe,
    NgIf,
    NgForOf
  ],
  styleUrls: ['./plp.component.scss']
})
export class PlpComponent implements OnInit {

  plpList$: Observable<TourPlpModel[]> = this._plpService.loadTours() as Observable<TourPlpModel[]>;

  constructor(private _plpService: PlpService, private _router: Router) { }

  ngOnInit(): void { }

  redirectToPdp(tourId: number): void {
    this._router.navigateByUrl('/pdp/' + tourId);
  }
}
