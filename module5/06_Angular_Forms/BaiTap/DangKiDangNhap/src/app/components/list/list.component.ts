import { Component, OnInit } from '@angular/core';
import {DataService} from "../../service/data.service";
import {Person} from "../../models/Person";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor(private _data:DataService) { }
  PersonList:Person[]=this._data.Persons;

  ngOnInit(): void {
  }

}
