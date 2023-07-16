import { Component } from '@angular/core';
import {Observable} from "rxjs";
import {AsyncPipe, NgIf} from "@angular/common";
import {SessionService} from "../../services/session.service";
import {Router} from "@angular/router";
import {RegisterService} from "../../services/register.service";

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  imports: [
    // AppSearchComponent,
    AsyncPipe,
    NgIf
  ],
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  isLoggedIn$: Observable<boolean> = this._authService.isLoggedIn();

  constructor(
    private _authService: RegisterService,
    private _sessionService: SessionService,
    private _router: Router) {
  }

  logout(): void {
    this._sessionService.removeFromStorage("token");
    this._router.navigateByUrl('/login');
  }

   swiss(): void {
      this._router.navigateByUrl('/tours/1/pdp');
    }
}
