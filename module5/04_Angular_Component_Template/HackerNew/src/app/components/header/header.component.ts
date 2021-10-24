import { Component, OnInit ,Input} from '@angular/core';
import {Person} from "../../Person";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() Student!:any[];

  constructor() { }

  ngOnInit(): void {
  }

}
