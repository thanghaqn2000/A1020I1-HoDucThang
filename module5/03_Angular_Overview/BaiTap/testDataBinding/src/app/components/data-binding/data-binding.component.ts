import {Component, OnInit} from '@angular/core';
import {Person} from "../Person";

@Component({
  selector: 'data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})

export class DataBindingComponent implements OnInit {

  Codegymer: Person = {
    name: "Đức Thắng",
    age: 20,
    gender: true,
    mark: 10,
    img: "https://thuthuatnhanh.com/wp-content/uploads/2019/07/anh-girl-xinh-facebook-tuyet-dep-387x580.jpg",
  };


  public user: any = {
    namee: "Thén",
    age: 20,
    gender: true,
    img: "https://thuthuatnhanh.com/wp-content/uploads/2019/07/anh-girl-xinh-facebook-tuyet-dep-387x580.jpg",
    size: 100
  };

  constructor() {

  }
  // @ts-ignore
  changeMark(event){
    this.Codegymer.mark=event.target.value;
  }

  ngOnInit(): void {
  }

}
