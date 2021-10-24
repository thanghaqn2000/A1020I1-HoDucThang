import {Component, OnInit, Input} from '@angular/core';
import {Person, StudentDao} from "../../Person";
import {DataServiceService} from "../../service/data-service.service";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  // @Input() StudentList!: any[];
  // getData() {
  //   this.Student = this.Students;
  // }

  // @ts-ignore
  myTracking(index, item) {
    return item.name;
  }
  constructor(public _dataService: DataServiceService) {

  }
  num=this._dataService.numService;
  StudentList=this._dataService.Students;
  ngOnInit(): void {
  }

  onClick() {
    console.log(this.num);
  }

  onClickService() {
    console.log(this._dataService.numService);
  }
}
