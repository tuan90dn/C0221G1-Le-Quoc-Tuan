import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator-app',
  templateUrl: './calculator-app.component.html',
  styleUrls: ['./calculator-app.component.scss']
})
export class CalculatorAppComponent implements OnInit {
  output: number;
  first: number;
  second: number;
  operator: string;
  onFirstChange(value) {
    this.first = Number(value);
  }
  onSecondChange(value) {
    this.second = Number(value);
  }
  onSelectChange(value) {
    this.operator = String(value);
  }

  constructor() { }

  ngOnInit(): void {
  }

  calculate() {
    switch (this.operator) {
      case '+' :
        this.output = this.first + this.second;
        break;
      case '-' :
        this.output = this.first - this.second;
        break;
      case '*' :
        this.output = this.first * this.second;
        break;
      case '/' :
        this.output = this.first / this.second;
        break;
    }
  }
}
