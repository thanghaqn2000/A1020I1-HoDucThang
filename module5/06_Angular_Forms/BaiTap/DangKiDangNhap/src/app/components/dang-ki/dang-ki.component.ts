import {Component, OnInit} from '@angular/core';
import {Person} from "../../models/Person";
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {DataService} from "../../service/data.service";

function comparePassword(c: AbstractControl) {
  const v = c.value;
  return (v.password === v.confirmPassword) ? null : {
    passwordnotmatch: true
  };
}

@Component({
  selector: 'app-dang-ki',
  templateUrl: './dang-ki.component.html',
  styleUrls: ['./dang-ki.component.css']
})
export class DangKiComponent implements OnInit {
  // @ts-ignore
  public user: Person;

  constructor(private _service: DataService) {
  }

  signInForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.pattern("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
      + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")]),
    pwGroup: new FormGroup({
      password: new FormControl('', [Validators.required, Validators.minLength(5)]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(5), comparePassword])
    }),
    age: new FormControl('', [Validators.required]),
    country: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required])
  });


  get getEmail() {
    return this.signInForm.get("email");
  }

  get getPassword() {
    return this.signInForm.get("password");
  }

  get getConfirmPassword() {
    return this.signInForm.get("confirmPassword");
  }

  get getAge() {
    return this.signInForm.get("age");
  }

  get getCountry() {
    return this.signInForm.get("country");
  }

  get getGender() {
    return this.signInForm.get("gender");
  }

  get getPhone() {
    return this.signInForm.get("phone");
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this._service.Persons.push(this.signInForm.value)
  }

  reset(signInForm: FormGroup) {
    signInForm.reset();

  }
}
