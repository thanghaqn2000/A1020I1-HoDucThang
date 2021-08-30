import {Component, OnInit} from '@angular/core';
import {Person} from "../../models/Person";
import {FormControl, FormGroup, NgForm} from "@angular/forms";

@Component({
  selector: 'app-dang-ki',
  templateUrl: './dang-ki.component.html',
  styleUrls: ['./dang-ki.component.css']
})
export class DangKiComponent implements OnInit {
  // @ts-ignore
  public user: Person;

  constructor() {
  }

  signInForm = new FormGroup({
    email: new FormControl(),
    password: new FormControl(),
    age: new FormControl(),
    country: new FormControl(),
    gender: new FormControl(),
    phone: new FormControl()
  });

  ngOnInit(): void {
  }

  onSubmit() {
    this.user = this.signInForm.value;
    console.log(this.user);
    // console.log(this.signInForm.value)
  }
}
