import {Component, OnInit} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {flatMap, map, Observable, switchAll, switchMap, switchMapTo, tap} from "rxjs";
import {CommonModule} from "@angular/common";
import {SessionService} from "../../services/session.service";
import {RegisterService} from "../../services/register.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  imports: [
    ReactiveFormsModule,  // реактивная форма
    CommonModule
  ],
  standalone: true  // обязательно добавляем
})
export class RegisterComponent implements OnInit{ // подключаем форму регистрации чтоб работал Ангулар

  form = this._fb.group({ // форма для заполнения
    username: ['', [Validators.required, Validators.email]],  // валидаторы (требования к форме)
    password: ['', [Validators.required, Validators.minLength(8)]],
  })

  isSubmit: Observable<boolean> = this.form.statusChanges.pipe( // каждый раз подписываемся на статус формы
    map(status => status === 'VALID') // форма становиться активной (валидной), когда отрабатывают валидаоры
  );

  constructor(
    private _fb: FormBuilder,
    private _registerService: RegisterService,
    private _sessionService: SessionService, private _router: Router) {
  }

  ngOnInit(): void {  // отнаследуемся от ngOnInit, теперь можем наблюдать что происходит с формой
    this.form.valueChanges.subscribe( // хотим знать что сейчас пользователь вводит
      value => {
        if (value.username?.includes('idiot')) {
          alert("what are you doing???")
        }
      }
    );

    this.form.statusChanges // отслеживаем статус формы валидная или не валидная форма
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
    const username: string = value.username as string;  // считывает данные с полей регистрации
    const password: string = value.password as string;
    this._registerService.register(username, password).subscribe(res => { // подписываемся и ждем
      this._sessionService.addToStorage("token", JSON.stringify(res));  // кладем в Сторедж токен
      this._router.navigateByUrl('/plp'); // после проверки токина, редирект на /plp
    });
  }
}
