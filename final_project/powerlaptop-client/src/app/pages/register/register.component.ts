import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { CommonModule } from "@angular/common";
import { map, Observable, tap } from "rxjs";

import { SessionService } from "../../services/session.service";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  standalone: true
})
export class RegisterComponent implements OnInit{

  form = this._fb.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
  })

  isSubmit: Observable<boolean> = this.form.statusChanges.pipe(
    map(status => status === 'VALID')
  );

  constructor(
    private _fb: FormBuilder,
    private _registerService: AuthService,
    private _sessionService: SessionService, private _router: Router) {
  }

  ngOnInit(): void {
    // this.form.valueChanges.subscribe(
    //   value => {
    //     if (value.username?.includes('idiot')) {
    //       alert("what are you doing???")
    //     }
    //   }
    // );

    this.form.statusChanges
      .pipe(
        tap(value => console.log(value)),
        map(value => {
          if (value === 'VALID') {
            return 1;
          }
          if (value === 'INVALID') {
            return 2;
          }
          return 0
        }),
        tap(value => {
          console.log("after")
          console.log(value)
        }),
      )
      .subscribe();
  }

  register(): void {
    let value = this.form.value;
    const username: string = value.username as string;
    const password: string = value.password as string;
    this._registerService.register(username, password).subscribe(res => {
      this._sessionService.addToStorage("token", JSON.stringify(res));
      this._router.navigateByUrl('/plp');
    });
  }
}
