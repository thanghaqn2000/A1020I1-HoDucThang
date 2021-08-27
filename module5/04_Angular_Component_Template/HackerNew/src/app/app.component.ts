import {Component} from '@angular/core';
import {Person, StudentDao} from "./Person";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  Student: Person[] = [
    {
      name: "Thắng",
      age: 17,
      class: "A1020i1",
      check: false
    },
  ];

  public Students: Person[] = StudentDao;

  title = 'HackerNew';
}
