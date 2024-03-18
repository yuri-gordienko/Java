import { Component } from '@angular/core';
import {AppSearchComponent} from "../../components/app-search/app-search.component";
import {AuthService} from "../../services/auth.service";
import {Observable} from "rxjs";
import {AsyncPipe, NgIf} from "@angular/common";
import {SessionService} from "../../services/session.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  imports: [
    AppSearchComponent,
    AsyncPipe,
    NgIf
  ],
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  isLoggedIn$: Observable<boolean> = this._authService.isLoggedIn();

  constructor(
    private _authService: AuthService,
    private _sessionService: SessionService,
    private _router: Router) {
  }

  logout(): void {
    this._sessionService.removeFromStorage("token");
    this._router.navigateByUrl('/login');
  }
}
