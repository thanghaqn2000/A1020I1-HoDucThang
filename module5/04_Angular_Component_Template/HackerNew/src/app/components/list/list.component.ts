import { Component, OnInit,Input } from '@angular/core';
import {Person, StudentDao} from "../../Person";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  @Input("StudentHeader") Student!:any[];

  // getData() {
  //   this.Student = this.Students;
  // }

  // @ts-ignore
  myTracking(index, item) {
    return item.name;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
