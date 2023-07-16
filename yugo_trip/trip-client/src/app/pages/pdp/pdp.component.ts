import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { CommonModule } from "@angular/common";

import { PdpService } from "../../services/pdp.service";
import { TourPdpModel } from "../../models/tour-pdp.model";

@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.scss'],
  imports: [CommonModule]
})
export class PdpComponent implements OnInit {

  tour?: TourPdpModel;

  constructor(
  private _router: Router,
  private _pdpService: PdpService) { }

  ngOnInit(): void {
    this._loadTour();
  }

  private _loadTour(): void {
    let url : string = this._router.routerState.snapshot.url;
    let tourId = url.split('/')[2];
    console.log('url', url)
    console.log('tourId', tourId)
    this._pdpService
      .loadTourById(tourId)
      .subscribe(value => {
        this.tour = value as TourPdpModel;
      });
  }
}
