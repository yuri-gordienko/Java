import { Component } from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {Router} from "@angular/router";
import {FormBuilder, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {map, Observable} from "rxjs";

import {SessionService} from "../../services/session.service";
import {RegisterService} from "../../services/register.service";

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  imports: [
    AsyncPipe,
    FormsModule,
    ReactiveFormsModule
  ],
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  form = this._fb.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(5)]],
  })

  isSubmit: Observable<boolean> = this.form.statusChanges.pipe(
    map(status => status === 'VALID')
  );

  constructor(
    private _fb: FormBuilder,
    private _registerService: RegisterService,
    private _sessionService: SessionService,
    private _router: Router) {
  }

  login(): void {
    let value = this.form.value;
    const username: string = value.username as string;
    const password: string = value.password as string;
    this._registerService.register(username, password).subscribe(res => {
      this._sessionService.addToStorage("token", JSON.stringify(res));
      this._router.navigateByUrl('/plp');
    });
  }
}
