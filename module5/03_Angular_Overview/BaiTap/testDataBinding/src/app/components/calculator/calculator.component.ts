import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  firstNumber = 0;
  secondNumber = 0;
  output = 0;
  operator = '+';

  // @ts-ignore
  onFirstChange(event) {
    this.firstNumber = Number(event.target.value);
  }

// @ts-ignore
  onSecondChange(event) {
    this.secondNumber = Number(event.target.value);
  }

//@ts-ignore
  onSelectChange(event) {
    this.operator = event.target.value;
    console.log(event.target.value);
  }

  calculator() {
    switch (this.operator) {
      case '+':
        this.output = this.firstNumber + this.secondNumber;
        break;
      case '-':
        this.output = this.firstNumber - this.secondNumber;
        break;
      case '*':
        this.output = this.firstNumber * this.secondNumber;
        break;
      case '/':
        this.output = this.firstNumber / this.secondNumber;
        break;
    }
  }

  constructor() {

  }

  ngOnInit()
    :
    void {
  }

}
