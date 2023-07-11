import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { PdpService } from "../../services/pdp.service";
import { TourPdpModel } from "../../models/tour-pdp.model";
import { AsyncPipe, JsonPipe, NgForOf, NgIf } from "@angular/common";


@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.scss'],
  imports: [NgIf, NgForOf]
})
export class PdpComponent implements OnInit {

  tour?: TourPdpModel;

  constructor(private _pdpService: PdpService, private _router: Router) {
  }

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
